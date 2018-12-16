package com.aaa.p2p.dao;

import com.aaa.p2p.entity.TreeNode;

import java.util.List;
import java.util.Map;

/**
 * className:PowerDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-07 17:53
 */
public interface PowerDao {
    /**
     * 通过该员工的roleid获取权限列表
     * @return
     */
    List<Map> getPowerList(Integer roleId);
    /**
     * 通过角色id查父id
     */
    List<Map> getFid(Integer roleId);

    /**
     * 毫无理由的查权限树
     * @return
     */
    List<Map> getPList();
    /**
     * 通过pid获取权限列表
     * @return
     */
    List<Map> selectTreeByPid(Map map);
    /**
     * 根据自己的id查父id
     */
    List<Map> selectFid(Integer id);

    /**
     * 添加节点
     * @param map
     * @return
     */
    int insertTree(Map map);

    /**
     * 更改节点
     * @param map
     * @return
     */
    int updateTree(Map map);
    /**
     * 删除节点
     */
    int deleteTree(Map map);
}
