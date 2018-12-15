package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * className:CheckBidService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-14 15:23
 */
public interface CheckBidService {
    /**
     * 查询标的列表
     * @param map
     * @return
     */
    List<Map> selectList(Map map);

    /**
     * 获取用户信息
     * @param map
     * @return
     */
    List<Map> selectUserReal(Map map);

    /**
     * 账户信息查询
     * @param map
     * @return
     */
    List<Map> selectAnccout(Map map);
    /**
     * 更改标的状态
     */
    int updateState(Map map);
}
