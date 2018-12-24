package com.aaa.p2p.controller;

import com.aaa.p2p.service.ForwardInfoService;
import com.aaa.p2p.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * className:ForwardInfoController
 * discription:前台用户信息控制台
 * author:ZhangSenYao
 * createTime:2018-12-14 14:20
 */
@Controller
@RequestMapping("/forwardInfo")
public class ForwardInfoController {

    @Autowired
    private ForwardInfoService fUserService;

    /**
     * 通过session获取用户信息
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSesInfo")
    public Map getSesInfo(int userId) {
        return fUserService.getSesInfo(userId);
    }

    /**
     * 修改支付密码
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changePayPsw")
    public int changePayPsw(@RequestParam Map map) {
        return fUserService.changePayPsw(map);
    }

    /**
     * 修改登录密码
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeLogPsw")
    public int changeLogPsw(@RequestParam Map map) {
        return fUserService.changeLogPsw(map);
    }

    /**
     * 修改手机号码
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeTel")
    public int changeTel(@RequestParam Map map) {
        return fUserService.changeTel(map);
    }

    /**
     * 修改银行卡号
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeBankNum")
    public int changeBankNum(@RequestParam Map map) {
        return fUserService.changeBankNum(map);
    }

    /**
     * 修改邮箱
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeEmail")
    public int changeEmail(@RequestParam Map map) {
        return fUserService.changeEmail(map);
    }

    /**
     * 跳转实名认证
     * @return
     */
    @RequestMapping("/toUserReal")
    public String toUserReal() {
        return "forward/forwarduserreal";
    }

    /**
     * 获取用户状态
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getStation")
    public int getStation(int userId) {
        return fUserService.getStation(userId);
    }

    /**
     * 获取省份
     * @return
     */
    @ResponseBody
    @RequestMapping("/getProvince")
    public List<Map> getProvince() {
        return fUserService.getProvince();
    }

    /**
     * 获取城市
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCity")
    public List<Map> getCity(@RequestParam Map map) {
        return fUserService.getCity(map);
    }

    /**
     * 获取地区
     * @return
     */
    @ResponseBody
    @RequestMapping("/getArea")
    public List<Map> getArea(@RequestParam Map map) {
        return fUserService.getArea(map);
    }

    private final ResourceLoader resourceLoader;
    @Autowired
    public ForwardInfoController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 取出配置文件中upload.path的值，赋给uploadPath类变量
     */
    @Value("${upload.path}")
    private String uploadPath;

    /**
     * 提交实名认证
     * @return
     */
    @ResponseBody
    @RequestMapping("/subReal")
    public int subReal(@RequestParam MultipartFile forwardPic, @RequestParam MultipartFile backPic, @RequestParam Map map) {
        if (forwardPic != null) {
            String newFileName = FileUtil.uploadFile(uploadPath, forwardPic);
            map.put("forwardPic", newFileName);
        }
        if (backPic != null) {
            String newFileName = FileUtil.uploadFile(uploadPath, backPic);
            map.put("backPic", newFileName);
        }
        return fUserService.subReal(map);
    }

    /**
     * 获取审核状态
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getChkSta")
    public Map getChkSta(int userId) {
        return fUserService.getChkSta(userId);
    }

    /**
     * 跳转视频认证
     * @return
     */
    @RequestMapping("/toUserVideo")
    public String toUserVideo() {
        return "forward/forwardvideo";
    }

    /**
     * 提交视频预约
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/subVideo")
    public int subVideo(@RequestParam Map map) {
        //System.out.println(map);
        return fUserService.subVideo(map);
    }

    /**
     * 获取视频审核状态
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVidSta")
    public Map getVidSta(int userId) {
        return fUserService.getVidSta(userId);
    }

    /**
     * 获取账户余额和应还资金总额
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getFstCount")
    public Map getFstCount(int userId) {
        return fUserService.getFstCount(userId);
    }

    /**
     * 获取还款计划
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRepayCount")
    public List<Map> getRepayCount(int userId) {
        return fUserService.getRepayCount(userId);
    }

    /**
     * 一次还清贷款
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/forOneRepay")
    public int forOneRepay(int userId) {
        return fUserService.forOneRepay(userId);
    }

}
