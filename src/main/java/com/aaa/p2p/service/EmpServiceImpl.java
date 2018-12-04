package com.aaa.p2p.service;

import com.aaa.p2p.dao.EmpDao;
import com.aaa.p2p.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * className:EmpServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-11-30 13:24
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    /**
     * 查询员工信息
     * @return
     */
    @Override
    public List<Emp> selectEmpList() {
        return empDao.selectEmpList();
    }
}
