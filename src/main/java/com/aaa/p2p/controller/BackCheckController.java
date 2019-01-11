package com.aaa.p2p.controller;

import com.aaa.p2p.service.BackCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public String toRealCheck() {
        return "back/userrealcheck";
    }

    @Autowired
    private BackCheckService backCheckService;

    /**
     * 实名审核分页
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

    /**
     * 跳转视频认证审核
     * @return
     */
    @RequestMapping("/toVideoCheck")
    public String toVideoCheck() {
        return "back/uservideocheck";
    }

    /**
     * 视频审核分页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/videoPage")
    public Object videoPage(@RequestBody Map map) {
        Map resultMap = new HashMap();
        resultMap.put("pageData", backCheckService.getPagesByParamT(map));
        resultMap.put("total", backCheckService.getPageCountT(map));
        return resultMap;
    }

    /**
     * 视频审核操作
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/chgVideo")
    public int chgVideo(@RequestBody Map map) {
        //System.out.println(map);
        return backCheckService.chgVideo(map);
    }

    /**
     * 跳转省份echars图
     * @return
     */
    @RequestMapping("/toUserProfit")
    public String toUserProfit() {
        return "back/userProfit";
    }

    /**
     * 获取各个省份人数
     * @return
     */
    @ResponseBody
    @RequestMapping("/addressNum")
    public List<Map> addressNum() {
        return backCheckService.addressNum();
    }

    /**
     * 跳转盈利echars图
     * @return
     */
    @RequestMapping("/toMonProfit")
    public String toMonProfit() {
        return "back/monProfit";
    }

    /**
     * 获取标ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/selBid")
    public List<Map> selBid() {
        return backCheckService.selBid();
    }

    /**
     * 月盈利统计
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getEChartsData")
    public List<Map> getEChartsData(int id) {
        return backCheckService.getEChartsData(id);
    }

}
