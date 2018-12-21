package com.aaa.p2p.controller;

import com.aaa.p2p.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

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
     *跳转到我要投资页面
     * @return
     */
    @RequestMapping("/toBid")
    public String toBid(){
        //把全部通过的表显示出来，没有带分页
        //model.addAttribute("bidList",bidService.getList());
        return "yrd/bidList";
    }

    /**
     *跳转到我要投资页面中的投资详情
     * @return
     */
    @RequestMapping("/toBidInfo")
    public String toBidInfo(int bidid,Model model){
        //获得List<map> 标的信息
        model.addAttribute("list",bidService.getListByBidId(bidid));
        //获得map  用户可用资金
        model.addAttribute("maxMoney",bidService.getMaxMoneyByBidId(bidid));
        return "yrd/bidInfo";
    }
}
