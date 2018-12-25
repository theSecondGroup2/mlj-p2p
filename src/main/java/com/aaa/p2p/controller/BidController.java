package com.aaa.p2p.controller;

import com.aaa.p2p.service.BidService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * className:BidController
 * discription:
 * author:mx
 * createTime:2018-12-18 15:22
 */
@Controller
@RequestMapping("/bid")
public class BidController {

    @Autowired
    private BidService bidService;

    /**
     * 获得投标列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object getList(){

        return bidService.getList();
    }

    /**
     * 获得投标列表带分页
     * @param map
     * @return
     */
    @RequestMapping("/getListBy")
    @ResponseBody
    public Object getListBy(@RequestParam Map map){
        System.out.println("map:"+map);
        Map resultMap = new HashMap();
        if (map.get("pageNo") != null){//分页的查询
            //设置当前第几页和每页显示数量
            PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
            //用PageInfo对结果进行包装
            PageInfo<Map> pageInfo = new PageInfo<Map>(bidService.getListBy(map));
            System.out.println(bidService.getListBy(map)+".......");
            resultMap = new HashMap();
            resultMap.put("total", pageInfo.getTotal());
            resultMap.put("list", pageInfo.getList());
        } else {//不分页的查询
            resultMap.put("bidList",bidService.getList());
        }
        return resultMap;
    }

    /**
     * 投标方法
     * 不加ResponseBody 返回Object时候返回 1 不加这个会非法参数异常
     * @param money
     * @return
     */
    @ResponseBody
    @RequestMapping("invest")
    public Object toInvest(double money, int bidId, HttpSession session){
        System.out.println(money);
        bidService.investMoney(money,bidId,session);
        return 1;
    }
}
