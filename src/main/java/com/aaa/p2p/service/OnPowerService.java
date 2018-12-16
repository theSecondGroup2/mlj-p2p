package com.aaa.p2p.service;

import java.util.List;

/**
 * className:OnPowerService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-16 18:54
 */
public interface OnPowerService {
    /**
     * 授权
     * @param powerIds
     * @param roleId
     * @return
     */
    int onPower(List powerIds,Integer roleId);
}
