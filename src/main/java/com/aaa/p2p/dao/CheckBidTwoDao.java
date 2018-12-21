package com.aaa.p2p.dao;

import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:CheckBidTwoDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-21 12:46
 */
public interface CheckBidTwoDao {
    /**
     * 通过标的id获取标的信息
     * @param bidId
     * @return
     */
    List<Map> getBidInfoByBidId(Integer bidId);

    /**
     *
     * @param bidId
     * @param yuebenxi 每期还款金额
     * @param date 还款结束日期
     * @param state 还款中
     * @param qishu 第几期每条加一
     * @param yueshu 贷款月数
     * @param method 等额本息
     * @param userId 贷款人id
     * @return
     */
    int insertBidRepayInFo(int bidId, Double yuebenxi, String date,String state,int qishu,String yueshu,String method,int userId);

    /**
     * 根据投标人id获取投标的金额和投标利息，查询投标记录表
     * @param userid
     * @return
     */
    List<Map> getBidAmount(int userid,int bidId);

    /**
     * 更改投资人的信息
     * @param bj 本金
     * @param benjin 本金
     * @param lixi 利息
     * @param userId 用户id
     * @return
     */
    int updateAccount(Double bj,Double benjin,Double lixi,int userId);

    /**
     * 更改借款人信息
     * @param zhaobiaojine 招标金额
     * @param benxihe 本息和
     * @return
     */
    int updateAccountJie(Double zhaobiaojine,Double benxihe,int userId);

    /**
     * 通过用户名查accountid
     * @param userId
     * @return
     */
    List<Map> selectAccountIdByUserId(int userId);

    /**
     * 插入账户流水表
     * @param userId 用户id
     * @param accountId 账户id
     * @param biandong 变动金额
     * @param yue 余额
     * @param type 流水类型
     * @return
     */
    int insertUserAccountFlow(int userId,int accountId,Double biandong,Double yue,String type);
}
