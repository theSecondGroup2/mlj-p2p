package com.aaa.p2p.controller;

import com.aaa.p2p.util.PhoneMsgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className:ForwardUserController
 * discription:
 * author:ZhangSenYao
 * createTime:2018-12-07 15:13
 */
@Controller
@RequestMapping("/forwardUser")
public class ForwardUserController {

    /**
     * 测试跳转页面
     * @return
     */
    @RequestMapping("/toRegTest")
    public String toRegTest() {
        return "forward/rigistertest";
    }

    /**
     * 发送短信测试
     * @param tel
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendCode")
    public int sendCode(String tel) {
        //System.out.println(tel);
        return PhoneMsgUtil.getModelMsg(tel);
    }

}
