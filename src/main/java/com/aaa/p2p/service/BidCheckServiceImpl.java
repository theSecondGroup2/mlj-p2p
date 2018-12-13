package com.aaa.p2p.service;

import com.aaa.p2p.dao.BidCheckDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * className:BidCheckServiceImpl
 * discription:
 * author:mx
 * createTime:2018-12-12 10:51
 */
@Controller
public class BidCheckServiceImpl implements BidCheckService {
    @Autowired
    BidCheckDao bidCheckDao;


    @Override
    public List<Map> getPageByParam(Map map) {
        return bidCheckDao.getPageByParam(map);
    }

    @Override
    public int getPageCount(Map map) {
        return bidCheckDao.getPageCount(map);
    }

    @Override
    public int batchUpdate(Map map) {
        return bidCheckDao.batchUpdate(map);
    }
}
