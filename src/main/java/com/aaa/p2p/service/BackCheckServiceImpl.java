package com.aaa.p2p.service;

import com.aaa.p2p.dao.BackCheckDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:BackCheckServiceImpl
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-18 16:52
 */
@Service
public class BackCheckServiceImpl implements BackCheckService {

    @Autowired
    private BackCheckDao backCheckDao;

    @Override
    public List<Map> getPagesByParam(Map map) {
        return backCheckDao.getPagesByParam(map);
    }

    @Override
    public int getPageCount(Map map) {
        return backCheckDao.getPageCount(map);
    }

}
