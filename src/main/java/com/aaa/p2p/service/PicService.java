package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * className:PicService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-12 17:05
 */
public interface PicService {
    /**
     * 获取图片列表
     * @param map
     * @return
     */
    List<Map> getPicByLoc(Map map);
    /**
     * 更改url
     *
     */
    int updateUrl(String url,String loc);
}
