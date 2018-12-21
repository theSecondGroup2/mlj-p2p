package com.aaa.p2p.service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * className:CheckBidTwoService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-20 21:27
 */
public interface CheckBidTwoService {
    /**
     * 满标二审通过
     * @param map
     * @return
     */
    int ChickTwoSuss(Map map, HttpSession httpSession);
}
