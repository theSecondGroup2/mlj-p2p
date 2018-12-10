package com.aaa.p2p.service;

import com.aaa.p2p.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 14:50
 */
@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptDao deptDao;
    /**
     * dept列表查询
     * @return
     */
    @Override
    public List<Map> getDeptList() {
        List<Map> deptList = deptDao.getDeptList();
        return deptList;
    }
    /**
     * 通过条件获取部门列表
     * @return
     */
    @Override
    public List<Map> getDeptListBy(Map map) {
        return deptDao.getDeptListBy(map);
    }

    /**
     * 添加
     * @param map
     * @return
     */
    @Override
    public int deptAdd(Map map) {
        return deptDao.deptAdd(map);
    }

    /**
     * 更新
     * @param map
     * @return
     */
    @Override
    public int updateDept(Map map) {
        return deptDao.updateDept(map);
    }

    /**
     * 删除
     * @param ID
     * @return
     */
    @Override
    public int deleteDept(Integer ID) {
        return deptDao.deleteDept(ID);
    }

    /**
     * 批量删除
     * @param
     * @return
     */
    @Override
    public int batchDel(Map ids) {
        String ides = ids.get("ids") + "";
        String[] idArr = ides.split(",");
        List IDs = new ArrayList();
        for (int i = 0; i< idArr.length;i++) {
            IDs.add(Integer.valueOf(idArr[i]));
        }
        int i =deptDao.batchDel(IDs);
        return  i;
    }
}
