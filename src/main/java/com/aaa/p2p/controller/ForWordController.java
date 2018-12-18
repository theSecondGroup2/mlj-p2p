package com.aaa.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:ForWordController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-18 10:36
 */
@Controller
@RequestMapping("/forword")
public class ForWordController {
    /**
     * 跳转index页面
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "yrd/index";
    }
    /**
     * 跳转borrow页面
     * @return
     */
    @RequestMapping("/borrow")
    public String borrow(){
        return "yrd/borrow";
    }
}
