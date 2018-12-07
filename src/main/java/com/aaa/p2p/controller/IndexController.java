package com.aaa.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:IndexController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-07 13:55
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping("/wel")
    public String login() {
        System.out.println(1111);
        return "/back/index";
    }
}
