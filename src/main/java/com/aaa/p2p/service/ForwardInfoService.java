package com.aaa.p2p.service;

import java.util.Map;

/**
 * interfaceName:ForwardInfoService
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-14 14:22
 */
public interface ForwardInfoService {

    /**
     * 通过session获取用户信息
     * @param userId
     * @return
     */
    Map getSesInfo(int userId);

    /**
     * 修改支付密码
     * @param map
     * @return
     */
    int changePayPsw(Map map);

    /**
     * 修改登录密码
     * @param map
     * @return
     */
    int changeLogPsw(Map map);

    /**
     * 修改电话号码
     * @param map
     * @return
     */
    int changeTel(Map map);

    /**
     * 修改银行卡号
     * @param map
     * @return
     */
    int changeBankNum(Map map);

    /**
     * 修改邮箱
     * @param map
     * @return
     */
    int changeEmail(Map map);

}
