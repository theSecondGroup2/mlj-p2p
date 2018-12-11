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

    /**
     * 删除员工
     * @param map
     * @return
     */
    int deleteEmp(Map map);

    /**
     * 通过用户名获取账号
     * @param userName
     * @return
     */
    List<Map> selectEmp(String userName);

    /**
     * 通过手机号获取用户
     * @param map
     * @return
     */
    List<Map> selectEmpByPhone(Map map);
}
