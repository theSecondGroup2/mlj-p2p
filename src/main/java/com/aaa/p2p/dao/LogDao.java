package com.aaa.p2p.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:LogDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-28 20:25
 */
public interface LogDao {
    /**
     * 插入登陆
     * @param map
     * @return
     */
    @Insert(value = "insert into tb_log values (tb_log_id.nextval,#{userName},#{ip},sysdate)")
    int insertLogin(Map map);

    /**
     * 查询是否有相同数据
     * @param map
     * @return
     */
    @Select(value = "select * from tb_log where username = #{userName} and logtime = sysdate")
    List<Map> selectLogin(Map map);

    /**
     * 查询登陆列表
     * @param map
     * @return
     */
    @Select(value = "select id,username,ip,to_char(logtime,'yyyy-mm-dd hh24:mi:ss') logtime from tb_log")
    List<Map> getList(Map map);
}
