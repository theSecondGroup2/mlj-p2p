package com.aaa.p2p.controller;

import com.aaa.p2p.entity.TreeNode;
import com.aaa.p2p.service.EmpService;
import com.aaa.p2p.service.PowerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private EmpService empService;

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



    /**
     * 在session中获取用户
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping("/user")
    public Object getUser(HttpSession httpSession){
        return httpSession.getAttribute("userName");
    }

    /**
     * 跳转后台首页
     *
     * @return
     */
    @RequestMapping("/wel")
    public String wel() {
        return "back/wel";
    }
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
     * 跳转用户登陆页面
     *
     * @return
     */
    @RequestMapping("/phoneLogin")
    public String phoneLogin() {
        return "back/phoneLogin";
    }
    /**
     * 获取验证码
     *
     * @return
     */
    @RequestMapping("/Msg")
    public int Msg() {
        return 1;
    }

    /**
     * 跳转手机登陆页面
     *
     * @return
     */
    @RequestMapping("/userLogin")
    public String userLogin() {
        return "back/userLogin";
    }
    /**
     * 通过手机号查询的登陆用户放到session中
     *
     */
    public void setPhoneSession(Map map,HttpSession httpSession){
        List<Map> maps = empService.selectEmpByPhone(map);
        httpSession.setAttribute("emp",maps);
    }
    /**
     * 手机登陆跳转首页
     * @param model
     * @return
     */
    @RequestMapping("/toPhoneLogin")
    public String toPhoneLogin(@RequestParam Map map, Model model,HttpSession httpSession) {
        setPhoneSession(map,httpSession);//将当前手机号登陆的emp查询的emp信息放到session中
        int size = empService.selectEmpByPhone(map).size();
        if (size == 0) {
            model.addAttribute("msg","手机号不存在");
            return "back/phoneLogin";
        } else {
            int msg = Msg();
            if (888888 == Integer.valueOf(map.get("msgCode")+"")){
                return "tree/index";
            } else {
                model.addAttribute("msg","验证码错误");
                return "back/phoneLogin";
            }
        }
    }
    /**
     * 通过用户名密码登陆查询的登陆用户放到session中
     *
     */
    public void setUserSession(String userName,HttpSession session){
        List<Map> maps = empService.selectEmp(userName);
        session.setAttribute("emp",maps.get(0));
    }
    /**
     * 用户名密码跳转欢迎页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(String userName, String passWord, Model model, HttpSession httpSession) {
        if (userName!=null&&userName!=""){
            //将用户放到session中
            httpSession.setAttribute("userName",userName);
            setUserSession(userName,httpSession);//通过用户名登陆的emp信息放到session中
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
                return "back/userLogin";
            } catch (IncorrectCredentialsException e) {
                //用户名不存在的异常
                model.addAttribute("msg","用户名和密码错误");
                return "back/userLogin";
            }
        }
        return "back/userLogin";
    }




}
