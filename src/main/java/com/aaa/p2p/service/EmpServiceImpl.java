package com.aaa.p2p.service;

import com.aaa.p2p.dao.EmpDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 14:50
 */
@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpDao empDao;
    /**
     * emp列表查询
     * @return
     */
    @Override
    public List<Map> getEmpList(Map map) {
        return empDao.getEmpList(map);
    }
}
