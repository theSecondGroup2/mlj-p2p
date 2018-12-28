package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * className:BackMoneyService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-24 18:25
 */
public interface BackMoneyService {
    /**
     * 还款
     * @param map
     * @return
     */
    int getBack(Map map);

    /**
     * 查询密码
     * @param map
     * @return
     */
    int selectPwd(Map map);
    /**
     * 更改标的状态为还款结束
     */
    int selectOver(Map map);
}
