package com.aaa.p2p.dao;

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
     * 通过bidid 来获得tb_account的可用余额
     * @param bidid
     * @return
     */
    @Select("select b.AVAILABLEBALANCE from TB_BIDINFO a left join tb_account b on a.userid=b.id where a.id=#{0}")
    Map getMaxMoneyByBidId(int bidid);

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
     * 更新标的信息
     * @param money
     * @return
     */
    @Update("update TB_BIDINFO set bidcurrentamount=#{param1} where id=#{param2} ")
    int investMoney(double money,int bidId);
}
