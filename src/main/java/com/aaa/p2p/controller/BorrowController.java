package com.aaa.p2p.controller;

import com.aaa.p2p.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:borrowController
 * discription:
 * author:mx
 * createTime:2018-12-13 16:45
 */
@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    BorrowService borrowService;
    /**
     * 跳转到前台创标页面
     * @return
     */
    @RequestMapping("/toBorrow")
    public String toBorrow(HttpSession httpSession){
        if ( httpSession.getAttribute("userInfo")!=null &&  httpSession.getAttribute("userInfo")!= ""){
            return  "forward/borrow";
        }
        else{
            return "forward/forwarduserlogin";
        }
    }

    /**
     * 通过session获得创表用户的信息
     * @return
     */
    @ResponseBody
    @RequestMapping("insert")
    public Object select(HttpServletRequest request, @RequestParam Map map){
        //通过session获得userID
        HttpSession session = request.getSession();
        Map resultMap = (Map)(session.getAttribute("userInfo"));
        String userID = resultMap.get("USERID")+"";

        return borrowService.insert(map);
    }

    /**
     *
     * @param userID
     * @return
     */
    @ResponseBody
    @RequestMapping("/select")
    public Object selectBidIf(@RequestParam Integer userID){
        System.out.println(borrowService.selectBidIf(userID));
        Map map=new HashMap();
        //判断这个用户是否有正在投的标
        map.put("list",borrowService.selectBidIf(userID));
        //判断是不是视频和实名通过了，都通过返回1，有没有通过的返回0
        String strUserID=userID+"";
        map.put("auditResult",borrowService.selectBidAudit(strUserID));
        map.put("userID",userID);
        return map;
        /* if(borrowService.selectBidIf(userID).size()>0){
            return 1;
        }else {
            return 0;
        }*/
    }
}
