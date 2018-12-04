package com.aaa.p2p.dao;

import com.aaa.p2p.entity.Emp;

import java.util.List;

/**
 * className:EmpDao
 * discription:
 * author:luRuiHua
 * createTime:2018-11-29 09:54
 */
public interface EmpDao {
    /**
     * 查询员工
     * @return
     */
    public List<Emp> selectEmpList();
}
