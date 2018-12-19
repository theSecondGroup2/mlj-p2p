package com.aaa.p2p.controller;

import com.aaa.p2p.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private BidService bidService;

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

    /**
     *
     * @return
     */
    @RequestMapping("/toBid")
    public String toBid(Model model){
        model.addAttribute("bidList",bidService.getList());
        return "yrd/list";
    }
}
