package com.aaa.p2p.controller;

import com.aaa.p2p.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className:RoleController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-09 20:53
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 获取角色列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRoleList")
    public Object getRoleList(){
        return roleService.getRoleList();
    }
}
