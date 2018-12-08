package com.aaa.p2p.controller;

import com.aaa.p2p.entity.TreeNode;
import com.aaa.p2p.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * className:PowerController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-07 17:51
 */
@Controller
@RequestMapping("/power")
public class PowerController {
    @Autowired
    private PowerService powerService;

    /**
     * 获取权限菜单树
     * @return
     */
    @ResponseBody
    @RequestMapping("/tree")
    public Object getTree(){
        List<TreeNode> powerList = powerService.getPowerList();
        return powerList;
    }


    /**
     * 跳转后台首页
     * @return
     */
    @RequestMapping("/toIndex")
    public String index(){
        return "tree/index";
    }

}
