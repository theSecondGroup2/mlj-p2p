package com.aaa.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:HelpCentreCroterller
 * discription:
 * author:gyq
 * createTime:2018-12-18 16:10
 */
@Controller
@RequestMapping("/helpcentre")
public class HelpCentreCroterller {

    /**
     * 跳转公司公告详细页面
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex (){
        return "yrd/公司公告详细.html";
    }
    /**
     * 跳转公司简介
     * @return
     */
    @RequestMapping("/toGsjj")
    public String toGsjj (){
        return "yrd/公司简介.html";
    }
    /**
     * 跳转合作伙伴.html
     * @return
     */
    @RequestMapping("/toHzhb")
    public String toHzhb (){
        return "yrd/合作伙伴.html";
    }
    /**
     * 跳转团队风采.html
     * @return
     */
    @RequestMapping("/toTdfc")
    public String toTdfc (){
        return "yrd/团队风采.html";
    }

    /**
     * 跳转媒体报道.html
     * @return
     */
    @RequestMapping("/toMtbd")
    public String toMtbd (){
        return "yrd/媒体报道.html";
    }
    /**
     * 跳转帮助中心.html
     * @return
     */
    @RequestMapping("/toBzzx")
    public String toBzzx (){
        return "yrd/帮助中心.html";
    }
    /**
     * 招贤纳士.html
     * @return
     */
    @RequestMapping("/toZxns")
    public String toZxns (){
        return "yrd/招贤纳士.html";
    }
    /**
     * 法律声明.html
     * @return
     */
    @RequestMapping("/toFlsm")
    public String toFlsm (){
        return "yrd/法律声明.html";
    }
    /**
     * 法律政策.html
     * @return
     */
    @RequestMapping("/toFlzc")
    public String toFlzc (){
        return "yrd/法律政策.html";
    }
    /**
     * 管理团队.html
     * @return
     */
    @RequestMapping("/toGltd")
    public String toGltd (){
        return "yrd/管理团队.html";
    }
    /**
     * 网站公告.html
     * @return
     */
    @RequestMapping("/toWzgg")
    public String toWzgg (){
        return "yrd/网站公告.html";
    }
    /**
     * 联系我们.html
     * @return
     */
    @RequestMapping("/toLxwm")
    public String toLxwm (){
        return "yrd/联系我们.html";
    }
    /**
     * 资费说明.html
     * @return
     */
    @RequestMapping("/toZfsm")
    public String toZfsm (){
        return "yrd/资费说明.html";
    }
}
