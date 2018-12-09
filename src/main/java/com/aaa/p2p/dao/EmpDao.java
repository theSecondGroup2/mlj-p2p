package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * className:PowerDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-07 17:53
 */
public interface EmpDao {
    /**
     * 获取权限列表
     * @return
     */
    List<Map> getEmpList(Map map);
}
