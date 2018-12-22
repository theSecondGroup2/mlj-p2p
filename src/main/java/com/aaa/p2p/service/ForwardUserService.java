package com.aaa.p2p.service;

import java.util.Map; /**
 * className:ForwardUserService
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-12 09:13
 */
public interface ForwardUserService {

    /**
     * 用户名唯一性校验
     * @param userName
     * @return
     */
    int userExist(String userName);

    /**
     * 手机号唯一性校验
     * @param tel
     * @return
     */
    int telExist(String tel);

    /**
     * 新增前台用户
     * @param map
     * @return
     */
    int addForwardUser(Map map);

    /**
     * 前台用户登录业务
     * @param map
     * @return
     */
    int checkNamePsw(Map map);

    /**
     * 获得session
     * @return
     */
    Map getSession();

    /**
     * 注销用户（销毁session）
     */
    int userLogOut();

    /**
     * 修改头像
     * @param map
     * @return
     */
    int chgHead(Map map);

    /**
     * 是否通过所有审核
     * @param userId
     * @return
     */
    int getResults(int userId);

}
