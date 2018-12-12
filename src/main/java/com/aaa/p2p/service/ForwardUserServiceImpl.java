package com.aaa.p2p.service;

import com.aaa.p2p.dao.ForwardUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:ForwardUserServiceImpl
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-12 09:15
 */
@Service
public class ForwardUserServiceImpl implements ForwardUserService {

    @Autowired
    private ForwardUserDao fUserDao;

    @Override
    public int userExist(String userName) {
        List<Map> mapList = fUserDao.userExist(userName);
        return mapList.size();
    }

    @Override
    public int telExist(String tel) {
        List<Map> mapList = fUserDao.telExist(tel);
        return mapList.size();
    }

    @Override
    public int addForwardUser(Map map) {
        return fUserDao.addForwardUser(map);
    }

}
