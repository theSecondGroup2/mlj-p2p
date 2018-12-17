package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * interfaceName:ForwardUserDao
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-12 09:16
 */
public interface ForwardUserDao {

    /**
     * 用户名唯一性校验
     * @param userName
     * @return
     */
    List<Map> userExist(String userName);

    /**
     * 手机号唯一性校验
     * @param tel
     * @return
     */
    List<Map> telExist(String tel);

    /**
     * 新增前台用户
     * @param map
     * @return
     */
    int addForwardUser(Map map);

    /**
     * 检查用户名密码是否正确
     * @param map
     * @return
     */
    List<Map> checkNamePsw(Map map);

    /**
     * 查询对应的userId
     * @param userName
     * @return
     */
    int selectId(String userName);

    /**
     * 插入到表TB_FWDINFO
     * @param userId
     * @return
     */
    int addToInfo(int userId);

    /**
     * 修改头像
     * @param map
     * @return
     */
    int chgHead(Map map);

    /**
     * 修改状态（可实名认证）
     * @return
     */
    int chgExist(Map map);

}
