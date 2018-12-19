package com.aaa.p2p.controller;

import com.aaa.p2p.service.BackCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:BackCheckController
 * discription:后台审核管理控制台
 * author:ZhangSenYao
 * createTime:2018-12-18 15:21
 */
@Controller
@RequestMapping("/backCheck")
public class BackCheckController {

    /**
     * 跳转实名认证审核
     * @return
     */
    @RequestMapping("/toRealCheck")
    public String toUserReal() {
        return "back/userrealcheck";
    }

    @Autowired
    private BackCheckService backCheckService;

    /**
     * 审核分页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/realPage")
    public Object realPage(@RequestBody Map map) {
        Map resultMap = new HashMap();
        resultMap.put("pageData", backCheckService.getPagesByParam(map));
        resultMap.put("total", backCheckService.getPageCount(map));
        return resultMap;
    }

    /**
     * 审核操作
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/chgCheck")
    public int chgCheck(@RequestBody Map map) {
        return backCheckService.chgCheck(map);
    }

}
