package com.aaa.p2p.service;

import com.aaa.p2p.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     * role列表查询
     * @return
     */
    @Override
    public List<Map> getRoleList() {
        return roleDao.getRoleList();
    }

    /**
     * 根据条件查询角色列表
     * @param map
     * @return
     */
    @Override
    public List<Map> getRoleListBy(Map map) {
        return roleDao.getRoleListBy(map);
    }

    /**
     * 角色添加
     * @param map
     * @return
     */
    @Override
    public int insertAdd(Map map) {
        return roleDao.insertAdd(map);
    }

    /**
     * 角色更新
     * @param map
     * @return
     */
    @Override
    public int updateRole(Map map) {
        return roleDao.updateRole(map);
    }

    /**
     * 角色删除
     * @param ID
     * @return
     */
    @Override
    public int deleteRole(Integer ID) {
        return roleDao.deleteRole(ID);
    }

    /**
     * 角色批量删除
     * @param ids
     * @return
     */
    @Override
    public int batchDel(Map ids) {
        String ides=ids.get("ids")+"";
        String[] idArr=ides.split(",");
        List IDs=new ArrayList();
        for (int i = 0; i < idArr.length; i++) {
            IDs.add(Integer.valueOf(idArr[i]));
        }
        int i=roleDao.batchDel(IDs);
        return i;
    }
}
