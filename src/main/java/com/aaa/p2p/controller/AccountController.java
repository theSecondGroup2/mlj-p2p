package com.aaa.p2p.controller;

import com.aaa.p2p.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * className:AccountController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-19 09:02
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 通过用户id获取用户账户
     * @param
     * @return
     */
    @RequestMapping("/byuserid")
    @ResponseBody
    public Object selectAccountByUserId( HttpSession httpSession){
        Map userInfo = (Map)httpSession.getAttribute("userInfo");
        return accountService.selectAccountByUserId(userInfo);
    }
}
