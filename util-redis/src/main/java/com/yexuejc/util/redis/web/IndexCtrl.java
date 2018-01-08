package com.yexuejc.util.redis.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.yexuejc.util.redis
 * @Description:
 * @author: maxf
 * @date: 2018/1/8 11:26
 */
@RestController
public class IndexCtrl {
    @Value("${application.version}")
    private String version;

    @RequestMapping("/")
    public String index() {
        return "Hello yexuejc util-redis project，version:" + version;
    }
}
