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

    /**
     * 提交实名认证
     * 1、将获取的地址信息拼接成详细地址存入到map
     * 2、添加到实名认证表（如果是重复添加则先删除旧的审核信息）
     * 3、修改登录表状态为3
     * @param map
     * @return
     */
    @Override
    public int subReal(Map map) {
        String province = fInfoDao.getPro(map);
        String city = fInfoDao.getCty(map);
        String area = fInfoDao.getAra(map);
        map.put("address", province+city+area+map.get("theDetail"));
        //System.out.println(map);
        int chg = fInfoDao.chgExist(map);
        fInfoDao.delOld(map);
        int sub = fInfoDao.subReal(map);
        if (chg == 1 && sub == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    public Map getChkSta(int userId) {
        return fInfoDao.getChkSta(userId);
    }

    @Override
    public int subVideo(Map map) {
        int chg = fInfoDao.chgExistTwo(map);
        int sub = fInfoDao.subVideo(map);
        if (chg == 1 && sub == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    public Map getVidSta(int userId) {
        return fInfoDao.getVidSta(userId);
    }

    @Override
    public Map getFstCount(int userId) {
        return fInfoDao.getFstCount(userId);
    }
}
