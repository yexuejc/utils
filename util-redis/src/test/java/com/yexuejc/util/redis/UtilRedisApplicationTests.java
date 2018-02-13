package com.yexuejc.util.redis;

import com.yexuejc.util.redis.service.RedisSrv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UtilRedisApplication.class)
public class UtilRedisApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    @Qualifier(value = "redis5SrvImpl")
    RedisSrv redis5Srv;

    @Test
    public void contextLoads() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(7000);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                    for (int i = 0; i < 70; i++) {
                        String gift = redis5Srv.getGift("b73c5054caea48e38977b06a30b5785b");
//                        System.out.println(gift);
                        set.add(gift);
                    }
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(set.size());
    }

}
