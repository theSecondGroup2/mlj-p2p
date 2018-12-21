package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * className:CheckBidOneDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-20 19:48
 */
public interface CheckBidOneDao {
    /**
     * 查询投标信息
     * @param map
     * @return
     */
    List<Map> selectBidSumbit(Map map);

    /**
     * 查询审核信息
     * @param map
     * @return
     */
    List<Map> selectBidAudit(Map map);
}
