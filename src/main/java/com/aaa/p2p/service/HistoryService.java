package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * className:HistoryService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-21 19:42
 */
public interface HistoryService {
    /**
     * 获取历史审核记录列表
     * @param map
     * @return
     */
    List<Map> getHistoryList(Map map);
}
