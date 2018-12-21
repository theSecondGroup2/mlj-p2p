package com.aaa.p2p.controller;

import com.aaa.p2p.service.CheckBidTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * className:ChickBidTwoController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-20 21:05
 */
@Controller
@RequestMapping("/two")
public class ChickBidTwoController {
    @Autowired
    private CheckBidTwoService checkBidTwoService;
    /**
     * 跳转满标二审页面
     * @return
     */
    @RequestMapping("/toTwo")
    public String toChilkBidTwo(){
        return "back/checkBidTwo";
    }
    /**
     * 满标二审通过
     */
    @RequestMapping("/ChickTwoSuss")
    @ResponseBody
    public Object ChickTwoSuss(@RequestBody Map map, HttpSession httpSession){
        return checkBidTwoService.ChickTwoSuss(map,httpSession);
    }
}
