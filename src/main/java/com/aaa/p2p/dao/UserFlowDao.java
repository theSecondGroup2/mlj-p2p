package com.aaa.p2p.dao;

import java.util.Map;

/**
 * className:UserFlowDao
 * discription:
 * author:gyq
 * createTime:2018-12-20 20:11
 */
public interface UserFlowDao {
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
