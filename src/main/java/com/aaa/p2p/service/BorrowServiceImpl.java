package com.aaa.p2p.service;

import com.aaa.p2p.dao.BorrowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        //把bidrate除以100放进去
        /*Object BIDRATE1 = map.get("BIDRATE");
        Integer BIDRATE = Integer.valueOf(BIDRATE1+"");
        map.put("BIDRATE",BIDRATE);*/
        return borrowDao.insert(map);
    }

    @Override
    public List<Map> selectBidIf(int userID) {
        return borrowDao.selectBidIf(userID);
    }

    @Override
    public int selectBidAudit(String USERID) {
        List<Map> maps = borrowDao.selectUserReal(USERID);
        int i = maps.size();
        List<Map> maps1 = borrowDao.selectVideo(USERID);
        int j= maps1.size();
        if(i==0||j==0){
            return 0;
        }
        return 1;
    }
}
