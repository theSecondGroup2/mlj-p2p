package com.aaa.p2p.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * className:BackMoneyDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-24 19:31
 */
public interface BackMoneyDao {
    /**
     * 更改标的状态
     * @return
     */
    int updateState(int bidId);

    /**
     * 通过标的id查标的状态
     * @param map
     * @return
     */
    List<Map> selectBidInfo(Map map);

    /**
     * 插入审核记录表
     * @param state
     * @param userId
     * @param date
     * @return
     */
    int insertBidAudit(String state, int userId, String date, int bidId);

    /**
     * 更改还款计划表为已还款
     * @param bidId
     * @param qishu
     * @return
     */
    int updateRepayInfo(int bidId, String qishu);

    /**
     * 查询密码
     * @param map
     * @return
     */
    List<Map> selectPwd(Map map);

    /**
     * 根据还款人和期数查还款金额
     * @param qishu
     * @param userId
     * @return
     */
    List<Map> selectMoney(String qishu, int userId);

    /**
     * 更改借款人账户信息
     * @param bidrepayamount
     * @return
     */
    int updateUserAccount(Double bidrepayamount,int userId,Double xinyong);

    /**
     * 插入账户流水表
     * @param userId
     * @param accountId
     * @param bidrepayamount
     * @param money
     * @param
     * @return
     */
    int insertBidFlow(int userId, int accountId, Double bidrepayamount, Double money, String state);

    /**
     * 根据投标人id查询投标金额
     *
     * @param userTid
     * @return
     */
    List<Map> selectAccountSubmit(int userTid,int bidId);

    /**
     * 更改还款人账户
     * @param money
     * @param lixi
     * @return
     */
    int updateUserTAccount(Double money, Double lixi,int userTid,Double benjin);
}
