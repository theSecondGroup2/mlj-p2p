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

    /**
     * 更改emp
     * @param map
     * @return
     */
    int updateEmp(Map map);
    /**
     * 新增emp
     * @param map
     * @return
     */
    int insertEmp(Map map);
}
