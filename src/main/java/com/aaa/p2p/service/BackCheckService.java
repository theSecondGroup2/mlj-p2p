package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * interfaceName:BackCheckService
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-18 16:50
 */
public interface BackCheckService {

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
     * 月盈利统计
     * @param id
     * @return
     */
    List<Map> getEChartsData(int id);

}
