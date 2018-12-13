package com.aaa.p2p.controller;

import com.aaa.p2p.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * className:TreeController
 * discription:对菜单树进行增删改
 * author:luRuiHua
 * createTime:2018-12-13 14:19
 */
@RequestMapping("/tree")
@Controller
public class TreeController {
    @Autowired
    private PowerService powerService;
    /**
     * 跳转权限菜单树的增删改查页面
     * @return
     */
    @RequestMapping("/goTreeList")
    public String goTreeList(){
        return "tree/treeList";
    }

    /**
     * 通过pid获得树的下拉框
     * @param map
     * @return
     */
    @RequestMapping("/selectTreeByPid")
    @ResponseBody
    public Object selectTreeByPid(@RequestBody Map map){
        return powerService.selectTreeByPid(map);
    }

    /**
     * 添加树
     * @param map
     * @return
     */
    @RequestMapping("/insertTree")
    @ResponseBody
    public Object insertTree(@RequestBody Map map){
        return powerService.insertTree(map);
    }
    /**
     * 添加树
     * @param map
     * @return
     */
    @RequestMapping("/updateTree")
    @ResponseBody
    public Object updateTree(@RequestBody Map map){
        return powerService.updateTree(map);
    }
    /**
     * 删除树
     * @param map
     * @return
     */
    @RequestMapping("/deleteTree")
    @ResponseBody
    public Object deleteTree(@RequestBody Map map){
        return powerService.deleteTree(map);
    }
}
