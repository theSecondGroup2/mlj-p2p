package com.aaa.p2p.service;

import com.aaa.p2p.dao.UserFlowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className:UserFlowServiceImpl
 * discription:
 * author:gyq
 * createTime:2018-12-20 20:14
 */
@Service
public class UserFlowServiceImpl implements UserFlowService{
    @Autowired
     private UserFlowDao userFlowDao;

    @Override
    public int add(Map map) {

        return userFlowDao.add(map);
    }

    @Override
    public int insertadd(Map map) {
        return userFlowDao.insertadd(map);
    }
}
