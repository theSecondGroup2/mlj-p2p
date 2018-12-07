package com.aaa.p2p.controller;

import com.aaa.p2p.entity.Emp;
import com.aaa.p2p.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * className:EmpController
 * discription:
 * author:luRuiHua
 * createTime:2018-11-29 09:34
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    /**
     * 测试跳转页面
     * @return
     */
    @RequestMapping("/hello")
    @ResponseBody
    public Object hello() {
        return "hello world!";
    }

    /**
     * 查询emp,跳转empList页面
     * @return
     */
    @RequestMapping("/empList")
    public String empList(Model model) {
        List<Emp> empList = empService.selectEmpList();
        //马哥真帅
        model.addAttribute(empList);
        return "empList";
    }
}
