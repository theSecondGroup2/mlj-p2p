package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

public interface BorrowService {
    /**
     * 创标的插入
     * @param map
     * @return
     */
    int insert(Map map);

    /**
     *判断是否可以投标
     * @param userID
     * @return
     */
    List<Map> selectBidIf(int userID);

    /**
     * 查询是否视频，实名认证
     * @param USERID
     * @return
     */
    int selectBidAudit(String USERID);
}
