package com.aaa.p2p.controller;

import com.aaa.p2p.dao.UserFlowDao;
import com.aaa.p2p.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * className:AccountController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-19 09:02
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserFlowDao userFlowDao;
    /**
     * 通过用户id获取用户账户
     * @param
     * @return
     */
    @RequestMapping("/byuserid")
    @ResponseBody
    public Object selectAccountByUserId( HttpSession httpSession){
        Map userInfo = (Map)httpSession.getAttribute("userInfo");
        return accountService.selectAccountByUserId(userInfo);
    }

    /**
     * 提现
     *
     * @param
     * @return
     */
    @RequestMapping("/updateAccountId")
    @ResponseBody
    public String updateAccountId(Integer tixian, HttpSession session) {
        Map userMap = (Map) session.getAttribute("userInfo");
        Integer userid = Integer.valueOf(userMap.get("USERID") + "");
        System.out.println("tixian:" + tixian);
        int i = accountService.updateAccountId(tixian, userid);
        Map map = new HashMap();
        map.put("tixian",tixian);
        map.put("USERID",userid);
        int j = userFlowDao.add(map);
        //userAccountController.tx1();
        if(i==j) {
            return "提现成功";

        }else {
            return "提现失败";
        }

        /*if (i > 0) {
            return "提现成功";
        } else {
            return "提现失败";
        }*/
        // return userAccountController.tx1();
    }

    /**
     * 充值后余额更新
     * @param
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("updateAccount")
    public String updateAccount(Integer chongzhi,HttpSession session){
        Map userMap = (Map)session.getAttribute("userInfo");
        Integer userid = Integer.valueOf(userMap.get("USERID")+"");
        System.out.println("chongzhi:"+chongzhi);
        int i = accountService.updateAccount(chongzhi,userid);
        Map map = new HashMap();
        map.put("chongzhi",chongzhi);
        map.put("USERID",userid);
        int j =userFlowDao.insertadd(map);

        if (i==j){
            return "充值成功";
        }else {
            System.out.println(j+"---------------------");
            return "充值失败";
        }
//        System.out.println(i);
//        if(i>0){
//            return "充值成功";
//        } else {
//            return "充值失败";
//        }
    }
    /**
     * 体现校验密码
     */
    @ResponseBody
    @RequestMapping("/checkNamePswd")
    public int checkNamePswd(@RequestParam Map map,HttpSession session){
        System.out.println("密码是："+map);
        Map userMap = (Map)session.getAttribute("userInfo");
        int userId = Integer.valueOf(userMap.get("USERID")+"");
        map.put("userId",userId);
        return accountService.selectAccountPsd(map);
    }

}
