package com.aaa.p2p.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:BidDao
 * discription:
 * author:mx
 * createTime:2018-12-18 15:54
 */

public interface BidDao {
    /**
     * 获取投标页面，不带分页
     * @return
     */
    @Select("select * from tb_bidinfo")
    List<Map> getList();

    /**
     * 获取投标页面根据bidid ,并且查出来最大可以投的金额
     * @return
     */
    @Select("select a.*,(bidamount-bidcurrentamount) as maxmoney from TB_BIDINFO a where Id=#{0}")
    List<Map> getListByBidId(int bidid);

    /**
     * 通过userID 来获得tb_account的可用余额
     * @param userID
     * @return
     */
    //@Select("select b.AVAILABLEBALANCE from TB_BIDINFO a left join tb_account b on a.userid=b.id where a.id=#{0}")
    @Select("select AVAILABLEBALANCE from tb_account where userID=#{param1}")
    Map getMaxMoneyByUserId(String userID);

    /**
     * 获得投标页面，带分页
     * @return
     */
    @Select("<script>select  a.*,round(bidcurrentamount/bidamount,2)*100 as BIDSCHEDULE from tb_bidInfo a " +
            "where bidState='审核通过'    " +
            "<if test=\"bidrate!=null and bidrate!=''\"> and ${bidrate}</if>" +
            "<if test=\"biddeadline!=null and biddeadline!=''\"> and ${biddeadline}</if>" +
            "<if test=\"bidrepaymentmethod!=null and bidrepaymentmethod!=''\"> and ${bidrepaymentmethod}</if>" +
            "</script>")
    List<Map> getListBy(Map map);

    /**
     * 更新标的信息，把标投的金额更新了
     * @param money
     * @return
     */
    @Update("update TB_BIDINFO set bidcurrentamount=#{param1} where id=#{param2} ")
    int investMoney(double money,int bidId);

    /**
     * 更新账户的可用余额，冻结金额
     * @param USERID
     * @param investMoney
     * @return
     */
    @Update("update TB_ACCOUNT set AVAILABLEBALANCE=AVAILABLEBALANCE-#{param2},FREEZINGAMOUNT=FREEZINGAMOUNT+#{param2} where userId=#{param1}")
    int updateMoney(String USERID,double investMoney);

    /**
     * 插入投资列表记录表
     * @param bidId
     * @param USERID
     * @param USERNAME
     * @param investMoney
     * @param bidRate
     * @return
     */
    @Insert("insert into TB_BID_SUBMIT  values (TB_BID_SUBMIT_id.nextval,#{param1},#{param2},#{param3},#{param4},sysdate,#{param5})")
    int insertInvest(int bidId,String USERID,double investMoney,double bidRate,String USERNAME);

    /**
     * 通过userID获得accountID
     * @param userID
     * @return
     */
    @Select("select ID from TB_ACCOUNT where userID=#{param1}")
    int getAccountIDByUserID(String userID);

    /**
     * 插入用户账户流水表
     * @param USERID
     * @param accountIDByUserID
     * @param investMoney
     * @param availablebalance
     * @return
     */
    @Insert("insert into TB_USER_ACCOUNT_FLOW values(TB_USER_ACCOUNT_FLOW_ID.nextval,#{param1},#{param2},#{param3},#{param4},sysdate,'冻结')")
    int insertFlow(String USERID,int accountIDByUserID,double investMoney,Object availablebalance);

    /**
     * 把标的状态改成满标，根据bidID
     * @param bidID
     * @return
     */
    @Update("update TB_BIDINFO set bidState='满标' where ID=#{param1}")
    int updateBidState(int bidID);
}
