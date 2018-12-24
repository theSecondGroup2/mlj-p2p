package com.aaa.p2p.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:BidFailDao
 * discription:
 * author:mx
 * createTime:2018-12-22 21:46
 */

public interface BidFailDao {
    /**
     * 获得所有流标的bidid
     * @return
     */
    @Select("select id from TB_BIDINFO where bidState='流标'")
    List<Map> getBidFailID();

    /**
     * 通过bidID来获得投资的列表
     * @param bidID
     * @return
     */
    @Select("select * from TB_BID_SUBMIT where BIDINFOID=#{param1}")
    List<Map> getInvestListByBidID(int bidID);

    /**
     * 流标后更新可用余额
     * @param userID
     * @param bidAmount
     * @return
     */
    @Update("update TB_ACCOUNT set AVAILABLEBALANCE=AVAILABLEBALANCE+#{param2},FREEZINGAMOUNT=FREEZINGAMOUNT-#{param2} " +
            "where userID=#{param1}")
    int updateMoneyByFail(int userID,double bidAmount);

    /**
     * 插入用户账户流水表
     * @param USERID
     * @param accountIDByUserID
     * @param investMoney
     * @param availablebalance
     * @return
     */
    @Insert("insert into TB_USER_ACCOUNT_FLOW values(TB_USER_ACCOUNT_FLOW_ID.nextval,#{param1},#{param2},#{param3},#{param4},sysdate,'流标解冻')")
    int insertFlow(String USERID,int accountIDByUserID,double investMoney,Object availablebalance);

    /**
     * 路标操作完成后把表单状态改为流标完成
     * @param bidID
     * @return
     */
    @Update("update TB_BIDINFO set bidState='流标完成' where id=#{param1}")
    int updateBidStateFailSuc(int bidID);
}
