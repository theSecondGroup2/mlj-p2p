package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * interfaceName:ForwardInfoDao
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-14 14:28
 */
public interface ForwardInfoDao {
    /**
     * 开户
     * @param map
     * @return
     */
    int insertAccount(Map map);

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

    /**
     * 获取用户状态
     * @param userId
     * @return
     */
    int getStation(int userId);

    /**
     * 获取省份
     * @return
     */
    List<Map> getProvince();

    /**
     * 获取城市
     * @param map
     * @return
     */
    List<Map> getCity(Map map);

    /**
     * 获取地区
     * @param map
     * @return
     */
    List<Map> getArea(Map map);

    /**
     * 省份名
     * @param map
     * @return
     */
    String getPro(Map map);

    /**
     * 城市名
     * @param map
     * @return
     */
    String getCty(Map map);

    /**
     * 地区名
     * @param map
     * @return
     */
    String getAra(Map map);

    /**
     * 提交实名认证
     * @param map
     * @return
     */
    int subReal(Map map);

    /**
     * 修改状态
     * @param map
     * @return
     */
    int chgExist(Map map);

    /**
     * 获取审核状态
     * @param userId
     * @return
     */
    Map getChkSta(int userId);

    /**
     * 删除旧审核信息
     * @param map
     */
    void delOld(Map map);

    /**
     * 修改状态
     * @param map
     * @return
     */
    int chgExistTwo(Map map);

    /**
     * 提交视频预约
     * @param map
     * @return
     */
    int subVideo(Map map);

    /**
     * 获取视频审核状态
     * @param userId
     * @return
     */
    Map getVidSta(int userId);

    /**
     * 获取账户余额和应还资金总额
     * @param userId
     * @return
     */
    Map getFstCount(int userId);

    /**
     * 获取还款计划
     * @param userId
     * @return
     *
     */
    List<Map> getRepayCount(int userId);

}
