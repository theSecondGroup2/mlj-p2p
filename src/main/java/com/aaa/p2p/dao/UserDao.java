package com.aaa.p2p.dao;

import java.util.List;
import java.util.Map;

/**
 * className:UserDao
 * discription:
 * author:luRuiHua
 * createTime:2018-12-05 08:44
 */
public interface UserDao {
    /**
     * 带参数的分页查询
     * @param map
     * @return
     * 如果使用注解的方式，动态sql必须在标签的<script></script>
     * 如果使用script标签，mybatis大于小于必须使用&gt; &lt;
     */
    List<Map> getPageByParam(Map map);

    /**
     * 获取分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 更新
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 删除
     * @param empNo
     * @return
     */
    int delete(Integer empNo);

    /**
     * 批量删除
     * @param empNos
     * @return
     */
    int batchDel(List empNos);
}
