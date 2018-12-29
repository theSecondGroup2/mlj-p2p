package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * className:LogService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-28 20:23
 */
public interface LogService {

    int insertLogin(Map map);

    /**
     * 查询是否同一时间插过了该数据
     * @param map
     * @return
     */
    List<Map> selectLogin(Map map);

    /**
     * 查询登陆列表
     * @param map
     * @return
     */
    List<Map> getList(Map map);
}
