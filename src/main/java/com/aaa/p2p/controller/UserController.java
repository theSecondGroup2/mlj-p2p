package com.aaa.p2p.controller;

import com.aaa.p2p.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:UserController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-05 09:30
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 根据session查资金记录页面
     */
    @ResponseBody
    @RequestMapping("/getAccountFlow")
    public Object getAccountFlow(HttpSession httpSession){
        Map map = (HashMap)httpSession.getAttribute("userInfo");
        int userId = Integer.valueOf(map.get("USERID")+"");
        List<Map> list = userService.getAccountFlow(userId);
        return list;
    }
    /**
     * 根据session查询投资列表
     */
    @ResponseBody
    @RequestMapping("/getReplyFlow")
    public Object getReplyFlow(HttpSession httpSession){
        Map map = (HashMap)httpSession.getAttribute("userInfo");
        int userId = Integer.valueOf(map.get("USERID")+"");
        List<Map> list = userService.getReplyFlow(userId);
        return list;
    }


    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "back/list";
    }

    /**
     * 分页
     * @param map
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object page(@RequestBody Map map){
        Map resultMap = new HashMap();
        //分页数据
        resultMap.put("pageData",userService.getPageByParam(map));
        //分页总数量
        resultMap.put("total",userService.getPageCount(map));
        return resultMap;
    }

    /**
     * 添加
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Map map){
        return userService.add(map);
    }
    /**
     * 更改
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return userService.update(map);
    }
    /**
     * 删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map map){
        return userService.delete(Integer.valueOf(map.get("empNo")+""));
    }
    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("/batchDel")
    public Object batchDel(@RequestBody Map map){
        return userService.batchDel(map);
    }

}
