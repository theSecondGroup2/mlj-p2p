package com.aaa.p2p.controller;

import com.aaa.p2p.service.HistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:HistoryCheckBidController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-21 19:24
 */
@Controller
@RequestMapping("/his")
public class HistoryCheckBidController {
    @Autowired
    private HistoryService historyService;
    /**
     * 跳转历史记录审核页面
     * @return
     */
    @RequestMapping("/toHis")
    public String toHistory(){
        return "back/history";
    }

    /**
     * 查询历史审核列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectHis")
    public Object selectHis(@RequestBody Map map){
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(historyService.getHistoryList(map));
        Map resultMap = new HashMap();
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());
        return resultMap;
    }
}
