package com.yexuejc.util.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationRun.class)
public class UtilSimpleApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("start>>>>>>>>>");
        System.out.println("end>>>>>>>>>>");
    }

}
