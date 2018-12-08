package com.aaa.p2p.service;


import com.aaa.p2p.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * className:UserServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-05 09:21
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    /**
     * 带参的分页查询
     * @param map
     * @return
     */
    @Override
    public List<Map> getPageByParam(Map map) {
        return userDao.getPageByParam(map);
    }

    /**
     * 查询分页数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return userDao.getPageCount(map);
    }

    /**
     * 添加
     * @param map
     * @return
     */
    @Override
    public int add(Map map) {
        return userDao.add(map);
    }

    /**
     * 修改
     * @param map
     * @return
     */
    @Override
    public int update(Map map) {
        return userDao.update(map);
    }

    /**
     * 删除
     * @param empNo
     * @return
     */
    @Override
    public int delete(Integer empNo) {
        return userDao.delete(empNo);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int batchDel(Map ids) {
        String ides = ids.get("ids") + "";
        String[] idArr = ides.split(",");
        List empNos=new ArrayList();
        for (int i = 0; i < idArr.length; i++) {
            empNos.add(Integer.valueOf(idArr[i]));
        }
        int i = userDao.batchDel(empNos);
        return i;
    }
}
