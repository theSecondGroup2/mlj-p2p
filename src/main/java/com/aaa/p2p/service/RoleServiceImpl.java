package com.aaa.p2p.service;

import com.aaa.p2p.dao.DeptDao;
import com.aaa.p2p.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 14:50
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;
    /**
     * dept列表查询
     * @return
     */
    @Override
    public List<Map> getRoleList() {
        return roleDao.getRoleList();
    }
}
