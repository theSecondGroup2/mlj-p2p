package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * className:PicDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-12 17:00
 */
public interface PicDao {
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
