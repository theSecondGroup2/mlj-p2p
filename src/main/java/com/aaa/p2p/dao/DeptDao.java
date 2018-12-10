package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * className:DeptDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 16:48
 */
public interface DeptDao {
    /**
     * 获取部门列表
     * @return
     */
    List<Map> getDeptList();
    /**
     * 通过条件获取部门列表
     * @return
     */
    List<Map> getDeptListBy(Map map);

    /**
     * 添加
     * @param map
     * @return
     */
    int deptAdd(Map map);

    /**
     * 更改dept
     * @param map
     * @return
     */
    int updateDept(Map map);

    /**
     * 删除
     * @param
     * @return
     */
    int deleteDept(Integer ID);

    /**
     * 批量删除
     * @param
     * @return
     */
    int batchDel(List IDs);
}
