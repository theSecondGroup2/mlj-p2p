package com.aaa.p2p.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * className:BidFail
 * discription:流标 每小时执行一次
 * author:mx
 * createTime:2018-12-22 21:03
 */
@Configuration          //证明这个类是一个配置文件
@EnableScheduling       //打开quartz定时器总开关
public class BidFail {
    /**
     * 每小时执行一次
     */
    @Scheduled(cron = "0 0 */1  * * * ")
    public void bidFail(){

    }
}
