package com.aaa.p2p.controller;

import com.aaa.p2p.service.RoleService;
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
    /**
     * 跳转到Role页面
     * @return
     */
    @RequestMapping("/toRole")
    public String toRole(){
        return "back/role";
    }
    /**
     *通过条件获取部门列表
     * @return
     */
    @RequestMapping("/getRoleListBy")
    @ResponseBody
    public Object getRoleListBy(@RequestBody Map map){
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(roleService.getRoleListBy(map));
        Map resultMap = new HashMap();
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());
        return resultMap;
    }
}
