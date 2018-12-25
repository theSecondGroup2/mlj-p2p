package com.aaa.p2p.service;

import java.util.Map;

/**
 * className:UserFlowService
 * discription:
 * author:gyq
 * createTime:2018-12-20 20:13
 */

public interface UserFlowService {
    /**
     * 添加
     * @param map
     * @return
     */
    int add(Map map);
    /**
     * 充值添加流水表
     * @param map
     * @return
     */
    int insertadd(Map map);
}
