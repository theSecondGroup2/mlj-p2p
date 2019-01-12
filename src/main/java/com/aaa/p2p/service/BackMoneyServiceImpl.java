package com.aaa.p2p.service;

import com.aaa.p2p.dao.BackMoneyDao;
import com.aaa.p2p.dao.CheckBidOneDao;
import com.aaa.p2p.util.P2PUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:BackMoneyServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-24 18:25
 */
@Transactional
@Service
public class BackMoneyServiceImpl implements BackMoneyService {
    @Autowired
    private CheckBidOneDao checkBidOneDao;
    @Autowired
    private BackMoneyDao backMoneyDao;
    /**
     * 单次还款
     * @param map
     * @return
     */
    @Override
    public int getBack(Map map) {
        int k = 0;
        String qishu = map.get("qishu")+"";//期数
        int bidId = Integer.valueOf(map.get("ID")+"");//标的id
        int userId = Integer.valueOf(map.get("userId")+"");//借款人id
        /**
         * 1.将标的状态改为还款中
         */
        updateState(bidId);
        //
        /**
         * 2.插入审核表中
         */
        List<Map> infoMaps = backMoneyDao.selectBidInfo(map);
        String state = infoMaps.get(0).get("BIDSTATE")+"";//标的状态
        String date = infoMaps.get(0).get("BIDAPPLYDATE")+"";//申请日期
        insertBidAudit(state,userId,date,bidId);
        /**
         * 3.还款计划表的状态改为已还款
         */
        updateRepayInFo(bidId,qishu);
        /**
         * 4.更改借款人用户账户的信息及流水
         * 借款人：1.余额减去还款金额
         *        2.待还金额减去还款金额
         *        3.剩余信用额度加上还款金额
         */
        //根据还款人和期数查询还款金额
        List<Map> maps1 = backMoneyDao.selectMoney(qishu, userId);
        Double bidrepayamount = Double.parseDouble(maps1.get(0).get("BIDREPAYAMOUNT")+"");//还款金额

        int i = updateUserAccount(bidrepayamount, userId,bidId);
        /**
         * 5.更改投资人人的用户账户及流水
         * 投资人：1.余额加还款金额
         *        2.代收本金减还款本金
         *        3.代收利息-本月利息
         */
        k = updateUserTAccount(map,bidrepayamount);
/**
 * 更改标的状态
 */
        selectOver(map);

        return k;
    }

    /**
     * 更改投资人的账户信息和流水
     * @param map
     * @return
     */
    private int updateUserTAccount(Map map,Double bidrepayamount) {
        int j = 0;
        String qishu = map.get("qishu")+"";//期数
        int bidId = Integer.valueOf(map.get("ID")+"");//标的id
        int userId = Integer.valueOf(map.get("userId")+"");//借款人id

        //根据bidid查询招标金额
        Map mmm = new HashMap();
        mmm.put("ID",bidId);
        List<Map> maps1 = backMoneyDao.selectBidInfo(mmm);
        Double zhaobiao = Double.parseDouble(maps1.get(0).get("BIDAMOUNT")+"");//招标金额
        Integer yueshu = Integer.valueOf(maps1.get(0).get("BIDDEADLINE")+"");//还款月数
        Double lilv = Double.parseDouble(maps1.get(0).get("BIDRATE")+"");//利率



        //根据标的id查投标详情表
        List<Map> maps = checkBidOneDao.selectBidSumbit(map);
        if (maps.size()>0){
            for (Map map1 : maps) {
                int userTid = Integer.valueOf(map1.get("USERID")+"");//投标人id

                //根据投标人id查询投标金额
                List<Map> maps2 = backMoneyDao.selectAccountSubmit(userTid,bidId);
                Double toubiao = Double.parseDouble(maps2.get(0).get("BIDAMOUNT")+"");//个人投标金额
                //根据招标金额和个人投标金额，计算投资人个人应得本息和
                Double money = bidrepayamount * (toubiao/zhaobiao);//投标人被还款金额
                Double interestTotle = P2PUtil.getMonthTotle(toubiao, lilv/100, yueshu);//每月本息和
                //每月本金
                Double yuebenjin = toubiao/yueshu;
                //每月利息
                Double lixi =  interestTotle - yuebenjin;


                //更改完成
                int i = backMoneyDao.updateUserTAccount(money, lixi, userTid,yuebenjin);


                /**
                 * 插入账户流水表
                 */
                Map map2 = new HashMap();
                map2.put("USERID",userTid);
                List<Map> map3 = backMoneyDao.selectPwd(map2);
                Double yue = Double.parseDouble(map3.get(0).get("AVAILABLEBALANCE")+"");//可用余额
                int accountId = Integer.valueOf(map3.get(0).get("ID")+"");//账户id
                j = backMoneyDao.insertBidFlow(userTid, accountId, money, yue, "收款");
            }
        }

        return j;
    }

    /**
     * 借款人账户及账户流水
     * @param bidrepayamount
     * @param userId
     * @return
     */
    private int updateUserAccount(Double bidrepayamount, int userId,int bidId) {
        //根据标的id查招标金额
        Map mmm = new HashMap();
        mmm.put("ID",bidId);
        List<Map> maps1 = backMoneyDao.selectBidInfo(mmm);
        Double zhaobiao = Double.parseDouble(maps1.get(0).get("BIDAMOUNT")+"");//招标金额
        Integer yueshu = Integer.valueOf(maps1.get(0).get("BIDDEADLINE")+"");//还款月数

        //加的信用额度
        Double xinyong = zhaobiao/yueshu;


        //更改借款人账户
        int i = backMoneyDao.updateUserAccount(bidrepayamount,userId,xinyong);
        //根据userid查询账户的剩余金额及账户id
        Map map = new HashMap();
        map.put("USERID",userId);
        List<Map> maps = backMoneyDao.selectPwd(map);
        Double money = Double.parseDouble(maps.get(0).get("AVAILABLEBALANCE")+"");//可用余额
        int accountId = Integer.valueOf(maps.get(0).get("ID")+"");//账户id
        //插入账户流水表
        int j = backMoneyDao.insertBidFlow(userId, accountId, bidrepayamount, money, "还款");
        return j;
    }

    /**
     * 业务层比较支付密码
     * @param map
     * @return
     */
    @Override
    public int selectPwd(Map map) {
        List<Map> list = backMoneyDao.selectPwd(map);
        int pwd = Integer.valueOf(list.get(0).get("TRANSACTIONPASSWORD")+"");
        int pwdqiantai = Integer.valueOf(map.get("login")+"");
        if (pwdqiantai == pwd){
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 查询还款列表已还款的的个数
     * @param map
     * @return
     */
    @Override
    public int selectOver(Map map) {
        int bidId = Integer.valueOf(map.get("ID")+"");//标的id
        //根据标的id查还款月数
        Map mmm = new HashMap();
        mmm.put("ID",bidId);
        List<Map> maps1 = backMoneyDao.selectBidInfo(mmm);
        Integer yueshu = Integer.valueOf(maps1.get(0).get("BIDDEADLINE")+"");//还款月数


        int i = backMoneyDao.selectOver(map);
        int k = Integer.valueOf(yueshu);
        int i1 = 0;
        if (i==k){
             i1 = backMoneyDao.updateBidInfo(map);
        }
        return i1;
    }

    /**
     * 3.更改还款计划表
     * @param bidId
     * @param qishu
     * @return
     */
    private int updateRepayInFo(int bidId, String qishu) {
        return backMoneyDao.updateRepayInfo(bidId,qishu);
    }

    /**
     * 1.将标的状态改为还款中
     */
    public int updateState(int bidId){
        return backMoneyDao.updateState(bidId);
    }
    /**
     * 2.插入审核表中
     */
    public int insertBidAudit(String state,int userId,String date,int bidId){
        return backMoneyDao.insertBidAudit(state,userId,date,bidId);
    }

}
