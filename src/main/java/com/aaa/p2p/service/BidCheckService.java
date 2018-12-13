package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

public interface BidCheckService {

    /**
     * 获取用户列表
     * @param map
     * @return
     */
    List<Map> getPageByParam(Map map);

    /**
     * 获得总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 单条更新与批量更新
     * @param map
     * @return
     */
    int batchUpdate(Map map);
}
