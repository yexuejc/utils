package com.yexuejc.util.simple.small;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PackageName: com.yexuejc.util.simple.small
 * @Description:
 * @author: maxf
 * @date: 2018/1/18 10:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DateTest {
    @Test
    public void str2date() {
        String str = "2018-01-18 10:21:48";
        System.out.println
                (">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
                        + String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str, new ParsePosition(0)
                )));
    }
}
