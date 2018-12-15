package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 14:50
 */
public interface RoleService {
    /**
     * 获取部门列表
     * @return
     */
    List<Map> getRoleList();
    /**
     * 通过条件获取角色列表
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
     * @param map
     * @return
     */
    int batchDel(Map map);
}
