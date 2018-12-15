package com.aaa.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 14:50
 */
public interface EmpService {
    /**
     * 获取员工列表
     * @return
     */
    List<Map> getEmpList(Map map);

    /**
     * 获取账号
     * @param userName
     * @return
     */
    List<Map> selectEmp(String userName);

    /**
     * 更改员工
     * @param map
     * @return
     */
    int updateEmp(Map map);
    /**
     * 新增员工
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
     * 通过手机号获取用户
     * @param map
     * @return
     */
    List<Map> selectEmpByPhone(Map map);

    /**
     * 批量删除
     * @param map
     * @return
     */
    int batchDel(Map map);
    /**
     * 更改密码
     * @param passWord
     * @param userName
     * @return
     */
    int updatepassword(String passWord,String userName);
}
