package com.aaa.p2p.controller;

import com.aaa.p2p.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className:BidController
 * discription:
 * author:mx
 * createTime:2018-12-18 15:22
 */
@Controller
@RequestMapping("/bid")
public class BidController {

    @Autowired
    private BidService bidService;

    /**
     * 获得投标列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object getList(){

        return bidService.getList();
    }
}
