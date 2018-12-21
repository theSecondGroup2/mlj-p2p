package com.aaa.p2p.service;

import com.aaa.p2p.dao.BidDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
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
    public Map getMaxMoneyByBidId(int bidid) {
        return bidDao.getMaxMoneyByBidId(bidid);
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
        Object bidcurrentamount = listByBidId.get(0).get("BIDCURRENTAMOUNT");
        Integer integer = Integer.valueOf(bidcurrentamount + "");
        //把投资金额加上已投标的金额
        double money=integer+investMoney;
        bidDao.investMoney(money,bidId);
        //更新个人余额 投资了多少个人余额减去多少
         session.getAttribute("userInfo");


        return 0;
    }
}
