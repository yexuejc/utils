package com.yexuejc.util.simple.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器测试类
 *
 * @PackageName: com.yexuejc.util.simple
 * @Description:
 * @author: maxf
 * @date: 2018/1/25 11:50
 * @desc <pre>@Component:启动springboot的自动扫描
 * 启用定时器需要在Application class 中加入注解 @EnableScheduling
 * </pre>
 */
@Component
//是否开启该@Component，在application.properties中配置
@ConditionalOnProperty("yexuejc.scheduled.enable")
public class TestScheduled {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 方法结束后间隔1毫秒再次执行
     */
    @Scheduled(fixedDelay = 1)
    public void Test1() throws InterruptedException {
        logger.info("我是定时器【Test1】，开始执行...");
        Thread thread = new Thread(() -> {
            // 子线程休眠五秒
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        //主线程等待子线程结束
        thread.join();
        logger.info("我是定时器【Test1】，执行结束");
    }
}
