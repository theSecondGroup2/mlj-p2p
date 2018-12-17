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
    public String toBorrow(){
        return "forward/borrow";
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
//        String userID = resultMap.get("USERID")+"";
      //  map.put("userID",userID);
        return borrowService.insert(map);
    }
}
