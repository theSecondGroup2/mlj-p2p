package com.aaa.p2p.service;

import com.aaa.p2p.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:LogService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-28 20:23
 */
@Service
public class LogServiceImpl implements LogService{
@Autowired
private LogDao logDao;

    /**
     * 插入登陆日志表
     * @param map
     * @return
     */
    @Override
    public int insertLogin(Map map) {
        return logDao.insertLogin(map);
    }

    /**
     * 查询是否同一时间插入了该数据
     * @param map
     * @return
     */
    @Override
    public List<Map> selectLogin(Map map) {
        return logDao.selectLogin(map);
    }

    /**
     * 查询登陆列表
     * @param map
     * @return
     */
    @Override
    public List<Map> getList(Map map) {
        return logDao.getList(map);
    }
}
