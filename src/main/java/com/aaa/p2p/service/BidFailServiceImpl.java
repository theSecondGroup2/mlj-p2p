package com.aaa.p2p.service;

import com.aaa.p2p.dao.BidDao;
import com.aaa.p2p.dao.BidFailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * className:BidFailServiceImpl
 * discription:
 * author:mx
 * createTime:2018-12-22 21:32
 */
@Transactional//事务
@Service
public class BidFailServiceImpl implements BidFailService {

    @Autowired
    private BidFailDao bidFailDao;
    @Autowired
    private BidDao bidDao;

    /**
     * 1、把标的状态改为流标
     * 2.更新个人账户表可用余额、冻结金额
     * 3、插入用户账户流水表  流水类型为流标解冻
     * @return
     */
    @Override
    public int bidFail() {
        //获得流标的bidid
        List<Map> listBidFailID = bidFailDao.getBidFailID();
        if(listBidFailID!=null&&listBidFailID.size()>0){
            for (Map map : listBidFailID) {
                Integer bidID = Integer.valueOf(map.get("ID") + "");
                //通过bidID获得投资人的id，钱数，再去解冻
                List<Map> investListByBidID = bidFailDao.getInvestListByBidID(bidID);
                if(investListByBidID!=null&&investListByBidID.size()>0){
                    for (Map map1 : investListByBidID) {
                        Integer userID = Integer.valueOf(map1.get("USERID") + "");
                        //投资金额
                        Double bidAmount = Double.valueOf(map1.get("BIDAMOUNT") + "");
                        //更新个人账户表钱数通过userID
                        bidFailDao.updateMoneyByFail(userID,bidAmount);
                        //插入用户账户流水表  流水类型为流标解冻
                        //先查询出流标后解冻后的个人余额
                        String strUserID = userID + "";
                        //先通过userid获得accountID
                        int accountIDByUserID = bidDao.getAccountIDByUserID(strUserID);
                        //获得变动后的可用余额,通过userID
                        Map maxMoneyByUserId = bidDao.getMaxMoneyByUserId(strUserID);
                        Object availablebalance = maxMoneyByUserId.get("AVAILABLEBALANCE");
                        bidFailDao.insertFlow(strUserID,accountIDByUserID,bidAmount,availablebalance);
                    }
                }
                //遍历每一个流标的表，改为状态为流标完成
                bidFailDao.updateBidStateFailSuc(bidID);
                //插入审核记录表
                //通过bidID来获得招标人的userID
                List<Map> listByBidId = bidDao.getListByBidId(bidID);
                String userID = listByBidId.get(0).get("USERID")+"";
                bidDao.insertFailAudit(userID,bidID);
            }
        }
        return 0;
    }
}
