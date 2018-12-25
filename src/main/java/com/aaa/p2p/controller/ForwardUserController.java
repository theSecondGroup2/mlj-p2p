package com.aaa.p2p.controller;

import com.aaa.p2p.service.ForwardUserService;
import com.aaa.p2p.util.FileUtil;
import com.aaa.p2p.util.ImgCheckUtil;
import com.aaa.p2p.util.PhoneMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * className:ForwardUserController
 * discription:前台用户控制台
 * author:ZhangSenYao
 * createTime:2018-12-07 15:13
 */
@Controller
@RequestMapping("/forwardUser")
public class ForwardUserController {

    /**
     * 发送短信
     * @param tel
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendCode")
    public int sendCode(String tel) {
        //System.out.println(tel);
        return PhoneMsgUtil.getModelMsg(tel);
    }

    private final ResourceLoader resourceLoader;
    @Autowired
    public ForwardUserController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 取出配置文件中upload.path的值，赋给uploadPath类变量
     */
    @Value("${upload.path}")
    private String uploadPath;

    /**
     * 获取随机图片验证码
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCheckPic")
    public Map<String, String> getCheckPic() {
        return ImgCheckUtil.setPic();
    }

    /**
     * 图片展示
     * @param fileName
     * @return
     */
    @RequestMapping("showPic")
    public ResponseEntity show(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity             .ok(resourceLoader.getResource("file:" + uploadPath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 跳转用户注册页面
     * @return
     */
    @RequestMapping("/toForwardUserReg")
    public String toForwardUserReg() {
        return "forward/forwarduserreg";
    }

    @Autowired
    private ForwardUserService fUserService;

    /**
     * 用户名唯一性校验
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping("/userExist")
    public int userExist(String userName) {
        return fUserService.userExist(userName);
    }

    /**
     * 手机号唯一性校验
     * @param tel
     * @return
     */
    @ResponseBody
    @RequestMapping("/telExist")
    public int telExist(String tel) {
        return fUserService.telExist(tel);
    }

    /**
     * 新增前台用户
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/addForwardUser")
    public int addForwardUser(@RequestParam Map map) {
        return fUserService.addForwardUser(map);
    }

    /**
     * 跳转用户登录页面
     * @return
     */
    @RequestMapping("/toForwardUserLogin")
    public String toForwardUserLogin() {
        return "forward/forwarduserlogin";
    }

    /**
     * 前台用户登录业务
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkNamePsw")
    public int checkNamePsw(@RequestParam Map map) {
        return fUserService.checkNamePsw(map);
    }

    /**
     * 跳转我的账户
     * @return
     */
    @RequestMapping("/toUserMain")
    public String toUserMain() {
        return "forward/forwardusermain";
    }

    /**
     * 获得session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSession")
    public Map getSession() {
        return fUserService.getSession();
    }

    /**
     * 用户注销
     */
    @ResponseBody
    @RequestMapping("/userLogOut")
    public int userLogOut() {
        return fUserService.userLogOut();
    }

    /**
     * 跳转账户基本信息
     * @return
     */
    @RequestMapping("/toUserInfo")
    public String toUserInfo() {
        return "forward/forwarduserinfo";
    }

    /**
     * 修改头像
     * @param map
     * @param filePic
     * @return
     */
    @ResponseBody
    @RequestMapping("/chgHead")
    public int chgHead(@RequestParam MultipartFile filePic,@RequestParam Map map) {
        if (filePic != null) {
            String newFileName = FileUtil.uploadFile(uploadPath, filePic);
            map.put("userHead", newFileName);
        }
        //System.out.println(map);
        return fUserService.chgHead(map);
    }

    /**
     * 是否通过所有审核
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getResults")
    public int getResults(int userId) {
        return fUserService.getResults(userId);
    }




}
