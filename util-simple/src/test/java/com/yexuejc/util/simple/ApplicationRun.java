package com.yexuejc.util.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @PackageName: com.yexuejc.util.simple
 * @Description:
 * @author: maxf
 * @date: 2017/12/29 15:31
 */
@MapperScan("com.yexuejc.util.simple.domain")
@SpringBootApplication
public class ApplicationRun {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }
}
