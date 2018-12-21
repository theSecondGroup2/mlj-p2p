package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * className:CheckBidOneService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-20 19:47
 */
public interface CheckBidOneService {
    /**
     * 查询投标信息
     * @param map
     * @return
     */
    List<Map> selectBidSumbit(Map map);

    /**
     * 查询审核表
     * @param map
     * @return
     */
    List<Map> selectBidAudit(Map map);
}
