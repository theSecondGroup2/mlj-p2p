package com.aaa.p2p.controller;

import com.aaa.p2p.service.ForwardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * className:ForwardInfoController
 * discription:前台用户信息控制台
 * author:ZhangSenYao
 * createTime:2018-12-14 14:20
 */
@Controller
@RequestMapping("/forwardInfo")
public class ForwardInfoController {

    @Autowired
    private ForwardInfoService fUserService;

    /**
     * 通过session获取用户信息
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSesInfo")
    public Map getSesInfo(int userId) {
        return fUserService.getSesInfo(userId);
    }

    /**
     * 修改支付密码
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changePayPsw")
    public int changePayPsw(@RequestParam Map map) {
        return fUserService.changePayPsw(map);
    }

    /**
     * 修改登录密码
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeLogPsw")
    public int changeLogPsw(@RequestParam Map map) {
        return fUserService.changeLogPsw(map);
    }

    /**
     * 修改手机号码
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeTel")
    public int changeTel(@RequestParam Map map) {
        return fUserService.changeTel(map);
    }

    /**
     * 修改银行卡号
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeBankNum")
    public int changeBankNum(@RequestParam Map map) {
        return fUserService.changeBankNum(map);
    }

    /**
     * 修改邮箱
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeEmail")
    public int changeEmail(@RequestParam Map map) {
        return fUserService.changeEmail(map);
    }

}
