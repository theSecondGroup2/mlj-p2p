package com.aaa.p2p.service;

import com.aaa.p2p.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 14:50
 */
@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptDao deptDao;
    /**
     * dept列表查询
     * @return
     */
    @Override
    public List<Map> getDeptList() {
        List<Map> deptList = deptDao.getDeptList();
        return deptList;
    }
}
