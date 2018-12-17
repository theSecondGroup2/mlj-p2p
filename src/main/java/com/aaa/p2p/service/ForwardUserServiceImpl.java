package com.aaa.p2p.service;

import com.aaa.p2p.dao.ForwardUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:ForwardUserServiceImpl
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-12 09:15
 */
@Service
public class ForwardUserServiceImpl implements ForwardUserService {

    @Autowired
    private ForwardUserDao fUserDao;

    @Override
    public int userExist(String userName) {
        List<Map> mapList = fUserDao.userExist(userName);
        return mapList.size();
    }

    @Override
    public int telExist(String tel) {
        List<Map> mapList = fUserDao.telExist(tel);
        return mapList.size();
    }

    @Override
    public int addForwardUser(Map map) {
        //插入到表TB_FWDLOGIN
        int addLogin = fUserDao.addForwardUser(map);
        //查询对应的userId
        String userName = (String)map.get("userName");
        int userId = fUserDao.selectId(userName);
        //插入到表TB_FWDINFO
        int addToInfo = fUserDao.addToInfo(userId);
        if (addLogin == 1 && addToInfo == 1) {
            return 1;
        }
        return 0;
    }

    /**
     * 前台用户登录业务
     * 1、用户名密码是否存在，如果不存在返回300，存在则下一步
     * 2、用户是否被冻结，如果被冻结则返回200，没有则下一步
     * 3、登录成功，存入Session，返回100
     * @param map
     * @return
     */
    @Override
    public int checkNamePsw(Map map) {
        int code = 0;
        List<Map> mapList = fUserDao.checkNamePsw(map);
        if (mapList.size() == 0) {
            code = 300;
            return code;
        }
        if ((mapList.get(0).get("USEREXIST")+"").equals("0")) {
            code = 200;
            return code;
        }
        Map sesMap = mapList.get(0);
        //存储到session中
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        session.setAttribute("userInfo", sesMap);
        code = 100;
        return code;
    }

    @Override
    public Map getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        return (Map)session.getAttribute("userInfo");
    }

    @Override
    public void userLogOut() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        session.invalidate();
    }

    @Override
    public int chgHead(Map map) {
        return fUserDao.chgHead(map);
    }

}
