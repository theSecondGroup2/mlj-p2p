package com.aaa.p2p.service;

import com.aaa.p2p.dao.CheckBidOneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:CheckBidOneServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-20 19:47
 */
@Service
public class CheckBidOneServiceImpl implements CheckBidOneService {
    @Autowired
    private CheckBidOneDao checkBidOneDao;
    /**
     * 查询投标信息
     * @param map
     * @return
     */
    @Override
    public List<Map> selectBidSumbit(Map map) {
        return checkBidOneDao.selectBidSumbit(map);
    }

    /**
     * 查询审核信息
     * @param map
     * @return
     */
    @Override
    public List<Map> selectBidAudit(Map map) {
        return checkBidOneDao.selectBidAudit(map);
    }
}
