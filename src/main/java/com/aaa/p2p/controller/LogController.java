package com.aaa.p2p.controller;

import com.aaa.p2p.service.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:LogController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-29 08:59
 */
@Controller
@RequestMapping("/loginFor")
public class LogController {
    @Autowired
    private LogService logService;

    /**
     * 页面跳转登陆日志查询
     * @return
     */
    @RequestMapping("/select")
    public String toLoginFor(){
        return "back/loginFor";
    }

    /**
     * 查询登陆日志
     * @return
     */
    @ResponseBody
    @RequestMapping("/log")
    public Object log(@RequestBody  Map map){
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(logService.getList(map));
        Map resultMap = new HashMap();
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());
        return resultMap;
    }

}
