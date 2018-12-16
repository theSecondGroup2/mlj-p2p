package com.aaa.p2p.dao;

import java.util.List;

/**
 * className:OnPowerDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-16 18:55
 */
public interface OnPowerDao {
    /**
     * 授权
     */
    int onPower(Integer powerId,Integer roleId);
    /**
     * 先删除权限
     */
    int deleteOnPower(Integer roleId);
}
