package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * interfaceName:BackCheckDao
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-18 16:53
 */
public interface BackCheckDao {

    /**
     * 带参分页查询
     * @param map
     * @return
     */
    List<Map> getPagesByParam(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 审核操作
     * @param map
     * @return
     */
    int chgCheck(Map map);

    /**
     * 带参分页查询
     * @param map
     * @return
     */
    List<Map> getPagesByParamT(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCountT(Map map);

    /**
     * 视频审核操作
     * @param map
     * @return
     */
    int chgVideo(Map map);

    /**
     * 获取各个省份人数
     * @return
     */
    List<Map> addressNum();

    /**
     * 获取标ID
     * @return
     */
    List<Map> selBid();

    /**
     * 月盈利统计 一个标id对应多个投资用户 x轴显示用户名 y轴显示投资金额
     * 根据标id查询
     * 投标金额 bs.bidAmount
     * 用户名 ui.userName
     * 月利率 bi.bidRate
     * 月利息=投标利息/标借贷月份 bs.bidRate/bi.bidDeadline
     * @param id
     * @return
     */
    List<Map> getEChartsData(int id);

}
