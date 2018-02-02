package com.yexuejc.util.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.yexuejc.util.simple.domain")
@SpringBootApplication
//启用定时器
@EnableScheduling
public class UtilSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilSimpleApplication.class, args);
    }
}
