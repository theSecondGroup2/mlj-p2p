package com.aaa.p2p.controller;

import com.aaa.p2p.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * className:DeptController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 16:43
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     *emp页面的下拉框
     * @return
     */
    @RequestMapping("/getDeptList")
    @ResponseBody
    public Object getDeptList(){
        return deptService.getDeptList();
    }

    /**
     * 跳转dept页面
     * @return
     */
    @RequestMapping("/toDept")
    public String toDept(){
        return "back/dept";
    }
}
