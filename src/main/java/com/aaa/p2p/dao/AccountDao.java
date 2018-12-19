package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * className:AccountDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-19 08:56
 */
public interface AccountDao {
    /**
     * 通过用户名查该人的账户
     * @param map
     * @return
     */
    List<Map> selectAccountByUserId(Map map);
}
