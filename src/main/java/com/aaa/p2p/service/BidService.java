package com.aaa.p2p.service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:BidService
 * discription:
 * author:mx
 * createTime:2018-12-18 15:51
 */

public interface BidService {
    /**
     * 获取标的页面不带分页
     * @return
     */
    List<Map> getList();

    /**
     * 通过bidid获得投标数据
     * @return
     */
    List<Map> getListByBidId(int bidid);

    /**
     * 通过bidid 来获得tb_account的可用余额
     * @param bidid
     * @return
     */
    Map getMaxMoneyByBidId(int bidid);

    /**
     * 获取投标页面，带分页
     * @return
     */
    List<Map> getListBy(Map map);

    /**
     * 投资金额，去更新投标金额
     * @param money
     * @return
     */
    int investMoney(double money, int bidId, HttpSession session);
}
