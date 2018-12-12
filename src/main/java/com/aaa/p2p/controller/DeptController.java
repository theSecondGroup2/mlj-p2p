package com.aaa.p2p.controller;

import com.aaa.p2p.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * className:DeptController
 * discription:对dept表进行增删该查
 * author:luRuiHua
 * createTime:2018-12-09 16:43
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     *emp页面的下拉框
     * @return
     */
    @RequestMapping("/getDeptList")
    @ResponseBody
    public Object getDeptList(){
        return deptService.getDeptList();
    }

    /**
     * 跳转dept页面
     * @return
     */
    @RequestMapping("/toDept")
    public String toDept(){
        return "back/dept";
    }
    /**
     *通过条件获取部门列表
     * @return
     */
    @RequestMapping("/getDeptListBy")
    @ResponseBody
    public Object getDeptListBy(@RequestBody Map map){
        //设置当前第几页和每页显示数量
        PageHelper.startPage(Integer.valueOf(map.get("pageNo") + ""), Integer.valueOf(map.get("pageSize") + ""));
        //用PageInfo对结果进行包装
        PageInfo<Map> pageInfo = new PageInfo<Map>(deptService.getDeptListBy(map));
        Map resultMap = new HashMap();
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageData", pageInfo.getList());
        return resultMap;
    }
    /**
     * 添加部門信息
     * @param map
     * @return
     */
    @RequestMapping("/insertAdd")
    @ResponseBody
    public Object insertAdd(@RequestBody Map map) {
        System.out.println("添加的："+map);
        return deptService.deptAdd(map);
    }

   /**
    * 更改员工信息
     * @param map
     * @return
             */
    @RequestMapping("/updateDept")
    @ResponseBody
    public Object updateDept(@RequestBody Map map) {
        System.out.println("更改的"+map);
        return deptService.updateDept(map);
    }

    /**
     * 删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map map){
        return deptService.deleteDept(Integer.valueOf(map.get("ID")+""));
    }

    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("/batchDel")
    public Object batchDel(@RequestBody Map map){
        return deptService.batchDel(map);
    }
}
