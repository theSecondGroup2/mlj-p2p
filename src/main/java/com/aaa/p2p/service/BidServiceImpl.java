package com.aaa.p2p.service;

import com.aaa.p2p.dao.BidDao;
import com.aaa.p2p.util.P2PUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:BidServiceImpl
 * discription:
 * author:mx
 * createTime:2018-12-18 15:53
 */
@Transactional//事务
@Service
public class BidServiceImpl implements BidService{
   @Autowired
   private BidDao bidDao;

    @Override
    public List<Map> getList() {
        return bidDao.getList();
    }

    @Override
    public List<Map> getListByBidId(int bidid) {
        return bidDao.getListByBidId(bidid);
    }

    @Override
    public Map getMaxMoneyByUserId(HttpSession session) {
        //通过session 获得userid
        Object info = session.getAttribute("userInfo");
        Map userInfo = (HashMap) info;
        String USERID = userInfo.get("USERID")+"";
        return bidDao.getMaxMoneyByUserId(USERID);
    }

    @Override
    public List<Map> getListBy(Map map) {
          return bidDao.getListBy(map);
    }

    /**
     * 更新标信息
     * @param investMoney
     * @return
     */
    @Override
    public int investMoney(double investMoney,int bidId,HttpSession session) {
        //更新标信息表的投资金额
        List<Map> listByBidId = bidDao.getListByBidId(bidId);
        //获得已投标金额
        Object bidcurrentamount = listByBidId.get(0).get("BIDCURRENTAMOUNT");
        //获得本金
        Object bidamount = listByBidId.get(0).get("BIDAMOUNT");
        //获得利率
        Object bidrate = listByBidId.get(0).get("BIDRATE");
        //获得月数
        Object biddeadline = listByBidId.get(0).get("BIDDEADLINE");
        Double integer = Double.valueOf(bidcurrentamount + "");
        Double bidamounts = Double.valueOf(bidamount + "");
        Double bidrates = Double.valueOf(bidrate + "");
        //把利率除以一百
        double bidratess = bidrates / 100;
        Integer biddeadlines = Integer.valueOf(biddeadline + "");
        //获取投资金额是不是等于标的最大投资金额
        List<Map> listByBidId1 = bidDao.getListByBidId(bidId);
        Double maxmoney = Double.valueOf(listByBidId1.get(0).get("MAXMONEY") + "");
        //投资金额等于标的最大投资金额，满标
        System.out.println(maxmoney+"..........");
        if(maxmoney==investMoney){
            System.out.println("满标");
            bidDao.updateBidState(bidId);
        }
        //把投资金额加上已投标的金额
        double money=integer+investMoney;
        bidDao.investMoney(money,bidId);
        //更新个人余额 投资了多少个人余额减去多少,并且冻结金额增加
        Object info = session.getAttribute("userInfo");
        Map userInfo = (HashMap) info;
        String USERID = userInfo.get("USERID")+"";
        String USERNAME = userInfo.get("USERNAME") + "";
        //执行dao层的更新钱方法
        bidDao.updateMoney(USERID,investMoney);
        //插入投资列表记录表 标id,用户id,用户名，投标金额，投标利息，投标时间
        //先获得投资可以获得的利息，通过本金，利率，月数
        double bidRate=(new P2PUtil().getInterestTotle(bidamounts,bidratess,biddeadlines))*(investMoney/bidamounts);
        bidDao.insertInvest(bidId,USERID,investMoney,bidRate,USERNAME);
        //插入用户账户流水表 userid 账户id 变动金额  变动后可用余额 流水时间  流水类型:冻结
        //先通过userid获得accountID
        int accountIDByUserID = bidDao.getAccountIDByUserID(USERID);
        //获得变动后的可用余额,通过userID
        Map maxMoneyByUserId = bidDao.getMaxMoneyByUserId(USERID);
        Object availablebalance = maxMoneyByUserId.get("AVAILABLEBALANCE");
        bidDao.insertFlow(USERID,accountIDByUserID,investMoney,availablebalance);


        return 0;
    }

    /**
     * 根据bidID来获得投资列表
     * @param bidID
     * @return
     */
    @Override
    public List<Map> getSubmitByBidId(int bidID) {
        return bidDao.getSubmitByBidId(bidID);
    }
}
