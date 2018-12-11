package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * className:DeptDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 16:48
 */
public interface RoleDao {
    /**
     * 获取角色列表
     * @return
     */
    List<Map> getRoleList();

    /**
     * 根据条件获取角色列表
     * @return
     */
    List<Map> getRoleListBy(Map map);

    /**
     * 添加新角色
     * @param map
     * @return
     */
    int insertAdd(Map map);

    /**
     * 更新角色
     * @param map
     * @return
     */
    int updateRole(Map map);

    /**
     * 通过ID单个删除角色
     * @param ID
     * @return
     */
    int deleteRole(Integer ID);

    /**
     * 通过ID批量删除角色
     * @param
     * @return
     */
    int batchDel(List IDs);
}
