package com.aaa.p2p.controller;

import com.aaa.p2p.service.BidFailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * className:BidFailController
 * discription:
 * author:mx
 * createTime:2018-12-22 21:25
 */
@Controller
@Configuration          //证明这个类是一个配置文件
@EnableScheduling       //打开quartz定时器总开关
public class BidFailController {
    @Autowired
    private BidFailService bidFailService;
    /**
     * 每小时执行一次
     */
    //@Scheduled(cron = "0 0 */1  * * * ")
    @Scheduled(cron = "0 0 *  * * * ")//10秒执行1次
    public void bidFail(){
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("流标开始  "+time);
        //流标操作
        bidFailService.bidFail();

    }

}
