package com.aaa.p2p.service;

import com.aaa.p2p.dao.ForwardInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:ForwardInfoServiceImpl
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-14 14:27
 */
@Service
public class ForwardInfoServiceImpl implements ForwardInfoService {

    @Autowired
    private ForwardInfoDao fInfoDao;

    @Override
    public Map getSesInfo(int userId) {
        return fInfoDao.getSesInfo(userId);
    }

    @Override
    public int changePayPsw(Map map) {
        return fInfoDao.changePayPsw(map);
    }

    @Override
    public int changeLogPsw(Map map) {
        return fInfoDao.changeLogPsw(map);
    }

    @Override
    public int changeTel(Map map) {
        return fInfoDao.changeTel(map);
    }

    @Override
    public int changeBankNum(Map map) {
        return fInfoDao.changeBankNum(map);
    }

    @Override
    public int changeEmail(Map map) {
        return fInfoDao.changeEmail(map);
    }

    @Override
    public int getStation(int userId) {
        return fInfoDao.getStation(userId);
    }

    @Override
    public List<Map> getProvince() {
        return fInfoDao.getProvince();
    }

    @Override
    public List<Map> getCity(Map map) {
        return fInfoDao.getCity(map);
    }

    @Override
    public List<Map> getArea(Map map) {
        return fInfoDao.getArea(map);
    }

}
