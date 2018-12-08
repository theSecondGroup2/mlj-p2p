package com.aaa.p2p.service;

import com.aaa.p2p.entity.TreeNode;

import java.util.List;


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
}
