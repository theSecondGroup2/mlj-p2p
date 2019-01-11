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

    @Override
    public int chgCheck(Map map) {
        return backCheckDao.chgCheck(map);
    }

    @Override
    public List<Map> getPagesByParamT(Map map) {
        return backCheckDao.getPagesByParamT(map);
    }

    @Override
    public int getPageCountT(Map map) {
        return backCheckDao.getPageCountT(map);
    }

    @Override
    public int chgVideo(Map map) {
        return backCheckDao.chgVideo(map);
    }

    @Override
    public List<Map> addressNum() {
        List<Map> mapList = backCheckDao.addressNum();
        for (Map map : mapList) {
            map.put("ADDRESS", (map.get("ADDR")+"").substring(0, 2));
        }
        return mapList;
    }

    @Override
    public List<Map> selBid() {
        return backCheckDao.selBid();
    }

    @Override
    public List<Map> getEChartsData(int id) {
        return backCheckDao.getEChartsData(id);
    }
}
