package com.aaa.p2p;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aaa.p2p.dao")
public class MljP2pApplication {

    public static void main(String[] args) {
        SpringApplication.run(MljP2pApplication.class, args);
    }
}
