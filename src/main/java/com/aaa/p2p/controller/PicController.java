package com.aaa.p2p.controller;

import com.aaa.p2p.service.PicService;
import com.aaa.p2p.util.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

/**
 * className:PicController
 * discription:
 * author:luRuiHua
 * createTime:2018-12-12 13:21
 */
@Controller
@RequestMapping("/pic")
public class PicController {
    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;

    @Autowired
    private PicService picService;

    /**
     * 查询url地址
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPicByLoc")
    public Object getPicByLoc(@RequestBody Map map){
        //通过map里面的路径查询url
        return picService.getPicByLoc(map);
    }
    /**
     * 上传图片，并且获得图片url
     * @return
     */
    @RequestMapping("/getPicUrl")
    @ResponseBody
    public Object getPicUrl(@RequestBody MultipartFile file,String loc){
        String filename = file.getOriginalFilename();
        String uploadUrl = "";
        try {
            if (file != null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS，返回一个url
                    uploadUrl = aliyunOSSUtil.upLoad(newFile);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return uploadUrl;
    }
    /**
     * 上传图片后的提交按钮
     */
    @RequestMapping("/goInsertPic")
    @ResponseBody
    public Object goInsertPic(@RequestBody Map map){
        //更改指定位置的图片url
        return picService.updateUrl(map.get("url")+"",map.get("loc")+"");
    }
    /**
     * 跳转更改轮播图页面
     * @return
     */
    @RequestMapping("/toPic")
    public String toPic(){
        return "back/pic";
    }
    /**
     * 跳转前台轮播图页面
     * @return
     */
    @RequestMapping("/toFIndex")
    public String toFIndex(){
        return "forward/index";
    }
}
