package com.aaa.p2p.controller;

import com.aaa.p2p.service.CheckBidService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * className:CheckBidController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-14 13:52
 */
@Controller
@RequestMapping("/bid")
public class CheckBidController {
    @Autowired
    private CheckBidService checkBidService;
    /**
     * 前台页面统计
     */
    @RequestMapping("/getSum")
    @ResponseBody
    public Object getSum(){
        Map sum = checkBidService.getSum();
        return sum;
    }

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/toCheckBid")
    public String toCheckBid(){
        return "back/checkBid";
    }

    /**
     * 查询标的列表
     * @param map
     * @return
     */
    @RequestMapping("/selectList")
    @ResponseBody
    public Object selectList(@RequestBody Map map){
        Map resultMap = new HashMap();
        if (map.get("pageNo") != null){//分页的查询
            //设置当前第几页和每页显示数量
            PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
            //用PageInfo对结果进行包装
            PageInfo<Map> pageInfo = new PageInfo<Map>(checkBidService.selectList(map));
            resultMap = new HashMap();
            resultMap.put("total", pageInfo.getTotal());
            resultMap.put("pageData", pageInfo.getList());
        } else {//不分页的查询
            resultMap.put("bidList",checkBidService.selectList(map));
        }
        return resultMap;
    }
    /**
     * 弹出框查询用户使命信息
     */
    @ResponseBody
    @RequestMapping("/selectUserReal")
    public Object selectUserReal(@RequestBody Map map){
        return checkBidService.selectUserReal(map);
    }
    /**
     * 弹出框查询账户信息
     */
    @ResponseBody
    @RequestMapping("/selectAnccout")
    public Object selectAnccout(@RequestBody Map map){
        return checkBidService.selectAnccout(map);
    }
    /**
     * 更改标的状态
     */
    @ResponseBody
    @RequestMapping("/updateState")
    public Object updateState(@RequestBody Map map, HttpSession session){

        return checkBidService.updateState(map,session);
    }
}
