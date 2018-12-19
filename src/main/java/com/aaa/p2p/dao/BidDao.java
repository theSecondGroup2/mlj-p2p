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
}
