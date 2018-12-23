package com.aaa.p2p.service;

import com.aaa.p2p.dao.BidAudit;
import com.aaa.p2p.dao.CheckBidDao;
import com.aaa.p2p.dao.CheckBidTwoDao;
import com.aaa.p2p.util.P2PUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * className:CheckBidTwoServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-20 21:27
 */
@Service
@Transactional//事务
public class CheckBidTwoServiceImpl implements CheckBidTwoService {
    @Autowired
    private CheckBidDao checkBidDao;
    @Autowired
    private BidAudit bidAudit;
    @Autowired
    private CheckBidTwoDao checkBidTwoDao;
    /**
     * 满标二审通过
     * @param map
     * @return
     */
    @Override
    @Transactional
    public int ChickTwoSuss(Map map, HttpSession httpSession) {
        /**
         * map中：
         * EMPID:审核人员id
         * ID:标的id
         * USERID:贷款人id
         * BIDSTATUS：审核结果
         * DATES：申请日期
         * ADVICE：审核意见
         */

        Map empMap = (Map)httpSession.getAttribute("emp");//拿到的是map集合
        int b = 0;
        if (empMap.size()>0){
            Integer id = Integer.valueOf(empMap.get("ID")+"");//拿到审核人员的id
            map.put("EMPID",id);//将审核人员id放到map中
            int i = bidAudit.insertBid(map);//插入审核记录表
            int j = checkBidDao.updateState(map);//更改标的状态为满标二审通过或者拒绝
            int k = insertBidRepayInfo(map);//调用底下的插入还款计划表的方法
            b = updateAccount(map);//更改用户账户表,插入账户流水表

            /*if (i==j){
                return 1;
            }
            return 0;*/
        }
        return b;
    }

    /**
     * 满标二审通过按钮的插入还款计划表
     */
    private int insertBidRepayInfo(Map map){
        int bidId = Integer.valueOf(map.get("ID")+"");//标的id
        List<Map> bidInfroList = checkBidTwoDao.getBidInfoByBidId(bidId);//获取到标的所有信息
        //基础数据准备
        Double benjin = Double.parseDouble(bidInfroList.get(0).get("BIDAMOUNT")+"");//本金（贷款金额）
        Double lilv = Double.parseDouble(bidInfroList.get(0).get("BIDRATE")+"")*0.01;//月利率
        String yueshu = bidInfroList.get(0).get("BIDDEADLINE")+"";//贷款月数
        int userId = Integer.valueOf(bidInfroList.get(0).get("USERID")+"");//贷款人id
        //获取当前日期并设置可以增加
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //计算每期还款金额
        Double yuebenxi = P2PUtil.getMonthTotle(benjin,lilv,Integer.valueOf(yueshu));
        //有几月添加几条数据
        int j = 0;
        for (int i = 1;i<=Integer.valueOf(yueshu);i++) {
            calendar.add(Calendar.MONTH, 1);//增加一个月
            checkBidTwoDao.insertBidRepayInFo(bidId,yuebenxi,sm.format(calendar.getTime()),"还款中",i,yueshu,"等额本息",userId);
        }
        return j;
    }
    /**
     * 更改用户账户表和账户流水表
     */
    public int updateAccount(Map map){
        int i = 0;
            if ("满标二审通过".equals(map.get("BIDSTATUS")+"")){
                int bidId = Integer.valueOf(map.get("ID")+"");//标的id
                int userId = Integer.valueOf(map.get("USERID")+"");//借款人id
                List list = (ArrayList)map.get("toubiaoIdArr");//拿出投标人的id

                for (int j = 0; j < list.size(); j++) {
                    //更改投标人账户
                    int tUserId = Integer.valueOf(list.get(j)+"");//拿出每个投标人的id
                    List<Map> bidAmount = checkBidTwoDao.getBidAmount(tUserId,bidId);//通过投资人id查询投资列表
                    Double BIDAMOUNT = Double.parseDouble(bidAmount.get(0).get("BIDAMOUNT")+"");//投标金额
                    Double BIDRATE = Double.parseDouble(bidAmount.get(0).get("BIDRATE")+"");//投标利息
                    //更改投资人的账户信息
                    /**
                     * 1.更改投资人的应收总利息=原利息+现利息
                     * 2.现冻结金额：冻结金额-投标的金额
                     * 3.应收金额=原应收金额+投标金额
                     */
                    i = checkBidTwoDao.updateAccount(BIDAMOUNT, BIDAMOUNT, BIDRATE,tUserId);

                    /**
                     * 插入账户流水列表
                     */
                    List<Map> maps = checkBidTwoDao.selectAccountIdByUserId(tUserId);
                    int accountId = Integer.valueOf(maps.get(0).get("ID")+"");//账户id
                    Double yue = Double.parseDouble(maps.get(0).get("AVAILABLEBALANCE")+"");//现余额
                    i = checkBidTwoDao.insertUserAccountFlow(tUserId,accountId,BIDAMOUNT,yue,"投标扣款");
                }
                //更改借钱人账户信息
                List<Map> bidInfroList = checkBidTwoDao.getBidInfoByBidId(bidId);//获取到标的所有信息
                //基础数据准备
                Double benjin = Double.parseDouble(bidInfroList.get(0).get("BIDAMOUNT")+"");//本金（贷款金额）
                Double lilv = Double.parseDouble(bidInfroList.get(0).get("BIDRATE")+"")*0.01;//月利率
                String yueshu = bidInfroList.get(0).get("BIDDEADLINE")+"";//贷款月数
                //计算出本息和
                Double totle = P2PUtil.getTotle(benjin, lilv, Integer.valueOf(yueshu));
                /**
                 * 1.余额=原余额+招标金额
                 * 2.待还金额=原待还金额+本息和
                 * 3.剩余信用额度=原剩余信用额度-招标金额
                 */
                //完成更改
                i = checkBidTwoDao.updateAccountJie(benjin, totle, userId);
                /**
                 * 插入账户流水列表
                 */
                List<Map> maps = checkBidTwoDao.selectAccountIdByUserId(userId);
                int accountId = Integer.valueOf(maps.get(0).get("ID")+"");//账户id
                Double yue = Double.parseDouble(maps.get(0).get("AVAILABLEBALANCE")+"");//现余额
                i = checkBidTwoDao.insertUserAccountFlow(userId,accountId,benjin,yue,"账户拨款");
            }
        return i;
    }

}
