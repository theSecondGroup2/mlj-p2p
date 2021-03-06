package com.aaa.p2p.controller;

import com.aaa.p2p.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * className:EmpController
 * discription:对emp表进行增删改查
 * author:luRuiHua
 * createTime:2018-12-09 14:23
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 跳转emp列表页面
     */
    @RequestMapping("/toList")
    public String toList() {
        return "back/emp";
    }

    /**
     * 获取员工信息
     * @param map
     * @return
     */
    @RequestMapping("/getEmpList")
    @ResponseBody
    public Object getEmpList(@RequestBody Map map) {
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(empService.getEmpList(map));
        Map resultMap = new HashMap();
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());
        return resultMap;
    }

    /**
     * 更改员工信息
     * @param map
     * @return
     */
    @RequestMapping("/updateEmp")
    @ResponseBody
    public Object updateEmp(@RequestBody Map map) {
        return empService.updateEmp(map);
    }
    /**
     * 插入员工信息
     * @param map
     * @return
     */
    @RequestMapping("/insertEmp")
    @ResponseBody
    public Object insertEmp(@RequestBody Map map) {
        return empService.insertEmp(map);
    }
    /**
     * 删除员工信息
     * @param map
     * @return
     */
    @RequestMapping("/deleteEmp")
    @ResponseBody
    public Object deleteEmp(@RequestBody Map map) {
        return empService.deleteEmp(map);
    }
    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("/batchDel")
    public Object batchDel(@RequestBody Map map){
        return empService.batchDel(map);
    }

    /**
     * 跳转更改密码页面
     */
    @RequestMapping("/updatePassWord")
    public String updatePassWord(){
        return "back/updatePassWord";
    }
    /**
     * 更改密码
     */
    @ResponseBody
    @RequestMapping("/updatepassword")
    public Object updatepassword(@RequestBody Map map, HttpSession httpSession){
        String userName = httpSession.getAttribute("userName")+"";
        return empService.updatepassword(map.get("passWord")+"",userName);
    }
    /**
     * 通过用户名查询原密码
     */
    @ResponseBody
    @RequestMapping("/selectEmpPassWord")
    public Object selectEmpPassWord( HttpSession httpSession){
        String userName = httpSession.getAttribute("userName")+"";
        Map map = new HashMap();
        map.put("userName",userName);
        List<Map> empList = empService.getEmpList(map);
        return empList;
    }
}
