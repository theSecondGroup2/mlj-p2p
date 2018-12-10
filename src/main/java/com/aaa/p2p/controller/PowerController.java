package com.aaa.p2p.controller;

import com.aaa.p2p.entity.TreeNode;
import com.aaa.p2p.service.PowerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/tree")
    public Object getTree() {
        List<TreeNode> powerList = powerService.getPowerList();
        return powerList;
    }


//    /**
//     * 跳转后台首页
//     *
//     * @return
//     */
//    @RequestMapping("/toIndex")
//    public String index() {
//        return "tree/index";
//    }

    /**
     * 跳转登陆页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "back/login";
    }
    /**
     * 跳转欢迎页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(String userName, String passWord, Model model) {
        System.out.println("账号是：" + userName);
        //shiro的关键代码，执行认证功能
        // 1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, passWord);
        //3.执行登陆方法
        try {
            //登陆成功
            subject.login(usernamePasswordToken);
            model.addAttribute("msg","登陆成功");
            //跳到欢迎页面
            return "tree/index";
        } catch (UnknownAccountException e) {
            //用户名不存在的异常
            model.addAttribute("msg","用户名不存在");
            return "back/login";
        } catch (IncorrectCredentialsException e) {
            //用户名不存在的异常
            model.addAttribute("msg","用户名和密码错误");
            return "back/login";
        }
    }




}
