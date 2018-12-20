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

}
