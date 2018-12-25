package com.aaa.p2p.controller;

import com.aaa.p2p.dao.BackMoneyDao;
import com.aaa.p2p.service.BackMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:BackMoneyController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-24 18:23
 */
@Controller
@RequestMapping("/back")
public class BackMoneyController {
    @Autowired
    private BackMoneyService backMoneyService;

    /**
     * 单次还款
     * @param map
     * @return
     */
    @RequestMapping("/one")
    @ResponseBody
    public Object getBack(@RequestParam Map map) {
        return backMoneyService.getBack(map);
    }
    /**
     * 通过session查密码
     */
    @RequestMapping("/pwd")
    @ResponseBody
    public Object selectPwd(@RequestParam Map map, HttpSession httpSession){
        Map sMap = (Map)httpSession.getAttribute("userInfo");
        int userId = Integer.valueOf(sMap.get("USERID")+"");
        map.put("USERID",userId);
        return backMoneyService.selectPwd(map);
    }
}
