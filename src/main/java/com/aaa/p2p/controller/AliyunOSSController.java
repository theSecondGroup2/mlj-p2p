package com.aaa.p2p.controller;

import com.aaa.p2p.util.AliyunOSSUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * className:AliyunOSSController
 * discription:无用的Controller，测试的deme，用于获得图片的url
 * author:luRuiHua
 * createTime:2018-12-12 10:58
 */
@Controller
@RequestMapping("/oss")
public class AliyunOSSController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;

    /**
     * 页面跳转
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    /**
     * 测试上传文件到阿里云OSS存储
     *
     * @return
     */
    @RequestMapping("/testUpload")
    @ResponseBody
    public String testUpload() {
        File file = new File("E:/Picture/test.jpg");
        AliyunOSSUtil aliyunOSSUtil = new AliyunOSSUtil();
        String url = aliyunOSSUtil.upLoad(file);
        return "success";
    }
    /**
     * 通过文件名下载文件
     */
    @RequestMapping("/testDownload")
    @ResponseBody
    public String testDownload() {
        AliyunOSSUtil aliyunOSSUtil = new AliyunOSSUtil();
        aliyunOSSUtil.downloadFile(
                "test/2018-12-04/e3f892c27f07462a864a43b8187d4562-rawpixel-600782-unsplash.jpg","E:/Picture/e3f892c27f07462a864a43b8187d4562-rawpixel-600782-unsplash.jpg");
        return "success";
    }
    /**
     * 列出某个文件夹下的所有文件
     */
    @RequestMapping("/testListFile")
    @ResponseBody
    public String testListFile() {
        AliyunOSSUtil aliyunOSSUtil = new AliyunOSSUtil();
        aliyunOSSUtil.listFile();
        return "success";
    }

    /**
     * 文件上传（供前端调用）
     */
    @RequestMapping(value = "/uploadFile")
    public String uploadPicture(@RequestParam("file") MultipartFile file, Model model) {
        String filename = file.getOriginalFilename();
        try {

            if (file != null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS
                    String uploadUrl = aliyunOSSUtil.upLoad(newFile);
                    model.addAttribute("url",uploadUrl);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "success";
    }
}
