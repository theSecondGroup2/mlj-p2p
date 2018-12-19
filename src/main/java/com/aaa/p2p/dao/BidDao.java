package com.aaa.p2p.dao;

import org.apache.ibatis.annotations.Select;

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
     * 获得投标页面，带分页
     * @return
     */
    @Select("<script>select  a.*,round(bidcurrentamount/bidamount,2)*100 as BIDSCHEDULE from tb_bidInfo a" +
           "<where>     " +
            "<if test=\"bidrate!=null and bidrate!=''\"> and ${bidrate}</if>" +
            "<if test=\"biddeadline!=null and biddeadline!=''\"> and ${biddeadline}</if>" +
            "<if test=\"bidrepaymentmethod!=null and bidrepaymentmethod!=''\"> and ${bidrepaymentmethod}</if>" +
            "</where></script>")
    List<Map> getListBy(Map map);
}
