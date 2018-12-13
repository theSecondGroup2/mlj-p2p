package com.aaa.p2p.service;

import com.aaa.p2p.entity.TreeNode;

import java.util.List;
import java.util.Map;


/**
 * className:PowerService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-07 17:55
 */
public interface PowerService {
    /**
     * 获取权限列表
     * @return
     */
    List<TreeNode> getPowerList();
    /**
     * 通过pid获取权限列表
     * @return
     */
    List<Map> selectTreeByPid(Map map);
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
