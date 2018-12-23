package com.aaa.p2p.service;

import com.aaa.p2p.dao.HistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:HistoryService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-21 19:42
 */
@Service
public class HistoryServiceImpl implements HistoryService{
    @Autowired
    private HistoryDao historyDao;

    @Override
    public List<Map> getHistoryList(Map map) {
        return historyDao.getHistoryList(map);
    }

    /**
     * 查询还款计划表
     * @param map
     * @return
     */
    @Override
    public List<Map> selectRepay(Map map) {
        return historyDao.selectRepay(map);

    }
}
