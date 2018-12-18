package com.aaa.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:UserAccountController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-18 15:17
 */
@Controller
@RequestMapping("/userAccount")
public class UserAccountController {
    /**
     * 跳往个人中心首页
     * @return
     */
    @RequestMapping("/Account")
    public String userAccount(){
        return "yrd/个人中心首页";
    }
    /**
     * 跳往资金记录
     * @return
     */
    @RequestMapping("/zjjl")
    public String zjjl(){
        return "yrd/个人中心-资金记录 ";
    }
    /**
     * 跳往资金记录
     * @return
     */
    @RequestMapping("/tzjl")
    public String tzjl(){
        return "yrd/个人中心-投资记录";
    }
    /**
     * 跳往回款计划
     * @return
     */
    @RequestMapping("/hkjh")
    public String hkjh(){
        return "yrd/个人中心-回款计划";
    }
    /**
     * 跳往开通第三方
     * @return
     */
    @RequestMapping("/ktdsf")
    public String ktdsf(){
        return "yrd/个人中心-开通第三方1";
    }
    /**
     * 跳往充值
     * @return
     */
    @RequestMapping("/cz1")
    public String cz1(){
        return "yrd/个人中心-充值1";
    }
    /**
     * 跳往提现
     * @return
     */
    @RequestMapping("/tx1")
    public String tx1(){
        return "yrd/个人中心-提现1";
    }
    /**
     * 跳往我的红包
     * @return
     */
    @RequestMapping("/wdhb")
    public String wdhb(){
        return "yrd/个人中心-我的红包";
    }
    /**
     * 个人兑换中心
     * @return
     */
    @RequestMapping("/dhls")
    public String dhls(){
        return "yrd/个人中心-兑换历史";
    }
    /**
     * 系统消息
     * @return
     */
    @RequestMapping("/xtxx")
    public String xtxx(){
        return "yrd/个人中心-系统消息";
    }
    /**
     * 系统消息
     * @return
     */
    @RequestMapping("/zhsz")
    public String zhsz(){
        return "yrd/个人中心-账户设置";
    }
}
