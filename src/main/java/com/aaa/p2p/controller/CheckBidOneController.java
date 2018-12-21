package com.aaa.p2p.controller;

import com.aaa.p2p.service.CheckBidOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * className:CheckBidOneController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-20 17:51
 */
@Controller
@RequestMapping("/one")
public class CheckBidOneController {
    @Autowired
    private CheckBidOneService checkBidOneService;
    /**
     * 跳转满标一审页面
     * @return
     */
    @RequestMapping("/toOne")
    public String toOne(){
        return "back/checkBidOne";
    }

    /**
     * 查询投标信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectBidSumbit")
    public Object selectBidSumbit(@RequestBody Map map){
        return checkBidOneService.selectBidSumbit(map);
    }
    /**
     * 查询审核信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectBidAudit")
    public Object selectBidAudit(@RequestBody Map map){
        return checkBidOneService.selectBidAudit(map);
    }
}
