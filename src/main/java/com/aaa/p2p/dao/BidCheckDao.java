package com.aaa.p2p.dao;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:BidCheckDao
 * discription:
 * author:mx
 * createTime:2018-12-12 10:18
 */

public interface BidCheckDao {

    /**
     * 带参数的分页查询
     * @param map
     * @return
     * 如果使用注解的方式，动态sql必须在标签<script>
     * 如果使用<script></script>，mybaties的大于小于，必须使用&gt;  和&lt
     */
    @Select("<script>select borrowuserid,borrowusername,input,to_char(borrowtime,'yyyy-MM-dd') as borrowtime,borrowmoney,repaytime,biddescribe,bidstatus,borrowmethod,methoddescribe,bidid,bidtime from \n" +
            "(select rownum rn,b.* from TB_BIDCHECK b\n" +
            "where rownum &lt; #{end}   " +
            "<if test=\"borrowUserId!=null and borrowUserId!=''\"> and borrowUserId=#{borrowUserId}</if>" +
            "<if test=\"borrowUserName!=null and borrowUserName!=''\"> and borrowUserName like '%'||#{borrowUserName}||'%'</if>" +
            "<if test=\"borrowMethod!=null and borrowMethod!=''\">  and borrowMethod =#{borrowMethod}</if>" +
            "<if test=\"bidStatus!=null and bidStatus!=''\">  and bidStatus =#{bidStatus}</if>" +
            " )a where a.rn &gt; #{start} </script>")
    List<Map> getPageByParam(Map map);

    /**
     * 获取分页总数量
     * @param map
     * @return
     */
    @Select("<script> select count(*) from TB_BIDCHECK <where>" +
            "<if test=\"borrowUserId!=null and borrowUserId!=''\"> and borrowUserId=#{borrowUserId}</if>" +
            "<if test=\"borrowUserName!=null and borrowUserName!=''\"> and borrowUserName like '%'||#{borrowUserName}||'%'</if>" +
            "<if test=\"borrowMethod!=null and borrowMethod!=''\">  and borrowMethod =#{borrowMethod}</if>" +
            "<if test=\"bidStatus!=null and bidStatus!=''\">  and bidStatus =#{bidStatus}</if>" +
            " </where></script>")
    int getPageCount(Map map);

    /**
     * 单条更新和批量更新
     * @param map
     * @return
     */
    @Update("update TB_BIDCHECK set bidstatus=#{BIDSTATUS} where bidid in(${BIDID})")
    int batchUpdate(Map map);

}
