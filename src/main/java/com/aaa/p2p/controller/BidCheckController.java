package com.aaa.p2p.controller;

import com.aaa.p2p.service.BidCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:BidCheckController
 * discription:
 * author:mx
 * createTime:2018-12-12 10:11
 */
@Controller
@RequestMapping("/bidCheck")
public class BidCheckController {
    @Autowired
    BidCheckService bidCheckService;

    /**
     * 跳转到投标审核页面
     * @return
     */
    @RequestMapping("/toBidCheck")
    public String toBidCheck(){
        return "back/bidCheck";
    }

    /**
     * 分页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public  Object list(@RequestBody Map map){
        Map resultMap =new HashMap();
        resultMap.put("pageData",bidCheckService.getPageByParam(map));
        resultMap.put("total",bidCheckService.getPageCount(map));
        return resultMap;
    }

    /**
     * 批量更新和单条更新
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("batchUpdate")
    public Object batchUpdate(@RequestBody Map map){
        System.out.println(map);
        return bidCheckService.batchUpdate(map);
    }
}
