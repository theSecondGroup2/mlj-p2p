package com.aaa.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
     * 跳往个人中心首页(我的账户)
     * @return
     */
    @RequestMapping("/Account")
    public String userAccount(HttpSession httpSession){

        if ( httpSession.getAttribute("userInfo")!=null &&  httpSession.getAttribute("userInfo")!= ""){
                return  "yrd/个人中心首页";
        }
        else{
            return "forward/forwarduserlogin";
        }

    }
    /**
     * 跳往资金记录
     * @return
     */
    @RequestMapping("/zjjl")
    public String zjjl(){
        return "yrd/个人中心-资金记录";
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
     * 账户设置
     * @return
     */
    @RequestMapping("/zhsz")
    public String zhsz(){
        return "yrd/个人中心-账户设置";
    }
    /**
     * 公司简介
     * @return
     */
    @RequestMapping("/gsjj")
    public String gsjj(){
        return "yrd/公司简介";
    }
    /**
     * 公司公告详情
     * @return
     */
    @RequestMapping("/gsggxx")
    public String gsggxx(){
        return "yrd/公司公告详细";
    }
    /**
     * 合作伙伴
     * @return
     */
    @RequestMapping("/hzhb")
    public String hzhb(){
        return "yrd/合作伙伴";
    }
    /**
     * 团队风采.html
     * @return
     */
    @RequestMapping("/tdfc")
    public String tdfc(){
        return "yrd/团队风采";
    }
    /**
     * 媒体报道.html
     * @return
     */
    @RequestMapping("/mtbd")
    public String mtbd(){
        return "yrd/媒体报道";
    }
    /**
     * 帮助中心.html
     * @return
     */
    @RequestMapping("/bzzx")
    public String bzzx(){
        return "yrd/帮助中心";
    }
    /**
     * 招贤纳士.html
     * @return
     */
    @RequestMapping("/zxns")
    public String zxns(){
        return "yrd/招贤纳士";
    }
    /**
     * 法律声明.html
     * @return
     */
    @RequestMapping("/flsm")
    public String flsm(){
        return "yrd/法律声明";
    }
    /**
     * 法律政策.html.html
     * @return
     */
    @RequestMapping("/flzc")
    public String flzc(){
        return "yrd/法律政策";
    }
    /**
     * 管理团队.html
     * @return
     */
    @RequestMapping("/gltd")
    public String gltd(){
        return "yrd/管理团队";
    }
    /**
     * 网站公告.html.html
     * @return
     */
    @RequestMapping("/wzgg")
    public String wzgg(){
        return "yrd/网站公告";
    }
    /**
     * 联系我们
     * @return
     */
    @RequestMapping("/lxwm")
    public String lxwm(){
        return "yrd/联系我们";
    }
    /**
     * 资费说明.html.html
     * @return
     */
    @RequestMapping("/zfsm")
    public String zfsm(){
        return "yrd/资费说明";
    }
    /**
     * borrow.html
     * @return
     */
    @RequestMapping("/borrow")
    public String borrow(){
        return "yrd/borrow";
    }
    /**
     * index.html
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpSession httpSession){
        if ( httpSession.getAttribute("userInfo")!=null ){
            return "yrd/index";
        }
        else{
            return "yrd/indextwo";
        }
    }
    /**
     * infor.html.html.html
     * @return
     */
    @RequestMapping("/infor")
    public String infor(){
        return "yrd/infor";
    }
    /**
     * list.html.html.html
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpSession httpSession){
            return "yrd/list";
        }
}
