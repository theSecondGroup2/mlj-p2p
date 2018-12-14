package com.aaa.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:borrowController
 * discription:
 * author:mx
 * createTime:2018-12-13 16:45
 */
@Controller
@RequestMapping("/borrow")
public class borrowController {

    @RequestMapping("/toBorrow")
    public String toBorrow(){
        return "forward/borrow";
    }
}
