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
}
