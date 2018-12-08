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
     * 获取权限列表
     * @return
     */
    List<Map> getPowerList();
}
