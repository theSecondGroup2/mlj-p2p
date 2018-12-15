package com.aaa.p2p.service;

import com.aaa.p2p.dao.CheckBidDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:CheckBidServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-14 15:23
 */
@Service
public class CheckBidServiceImpl implements CheckBidService {
    @Autowired
    private CheckBidDao checkBidDao;

    /**
     * 查询标的信息列表
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> selectList(Map map) {
        return checkBidDao.selectList(map);
    }

    /**
     * 获取用户信息
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> selectUserReal(Map map) {
        return checkBidDao.selectUserReal(map);
    }

    /**
     * 账户信息查询
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> selectAnccout(Map map) {
        return checkBidDao.selectAccount(map);
    }

    /**
     * 确定通过审核的
     * @param map
     * @return
     */
    @Override
    public int updateState(Map map) {
        map.get("");
        return checkBidDao.updateState(map);
    }
}

