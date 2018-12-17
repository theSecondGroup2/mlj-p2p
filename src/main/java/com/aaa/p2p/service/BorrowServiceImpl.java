package com.aaa.p2p.service;

import com.aaa.p2p.dao.BorrowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className:BorrowServiceImpl
 * discription:
 * author:mx
 * createTime:2018-12-14 19:55
 */
@Service
public class BorrowServiceImpl implements BorrowService{
    @Autowired
    BorrowDao borrowDao;

    @Override
    public int insert(Map map) {
        return borrowDao.insert(map);
    }
}
