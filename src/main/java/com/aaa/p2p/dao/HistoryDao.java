package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * className:HistoryDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-21 19:43
 */
public interface HistoryDao {
    /**
     * 获取历史列表
     * @param map
     * @return
     */
    List<Map> getHistoryList(Map map);
}
