package com.aaa.p2p.dao;



import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:BidCheckDao
 * discription:
 * author:mx
 * createTime:2018-12-12 10:18
 */

public interface CheckBidDao {
    /**
     * 查询标的信息列表
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
     * 查询账户信息
     * @param map
     * @return
     */
    List<Map> selectAccount(Map map);
    /**
     * 更改标的状态
     */
    int updateState(Map map);
}
