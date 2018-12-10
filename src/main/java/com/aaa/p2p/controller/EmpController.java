package com.aaa.p2p.controller;

import com.aaa.p2p.service.EmpService;
import com.alibaba.fastjson.JSON;
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
 * className:EmpController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 14:23
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 跳转emp列表页面
     */
    @RequestMapping("/toList")
    public String toList() {
        return "back/emp";
    }

    @RequestMapping("/getEmpList")
    @ResponseBody
    public Object getEmpList(@RequestBody Map map) {
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(empService.getEmpList(map));
        Map resultMap = new HashMap();
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());
        return resultMap;
    }

    /**
     * 更改员工信息
     * @param map
     * @return
     */
    @RequestMapping("/updateEmp")
    @ResponseBody
    public Object updateEmp(@RequestBody Map map) {
        System.out.println("更改的"+map);
        return empService.updateEmp(map);
    }
    /**
     * 插入员工信息
     * @param map
     * @return
     */
    @RequestMapping("/insertEmp")
    @ResponseBody
    public Object insertEmp(@RequestBody Map map) {
        System.out.println("添加的："+map);
        return empService.insertEmp(map);
    }
}
