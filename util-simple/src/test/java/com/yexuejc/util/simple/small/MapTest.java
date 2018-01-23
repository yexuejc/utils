package com.yexuejc.util.simple.small;

import com.yexuejc.util.base.util.StrUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.yexuejc.util.simple.small
 * @Description:
 * @author: maxf
 * @date: 2018/1/19 16:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class MapTest {

    @Test
    public void nullExp() {
        Map<String, Object> map = new HashMap<>(6);
        String outerTid = String.valueOf(map.get("outer_tid"));
        if (StrUtil.isEmpty(outerTid)||"null".equals(outerTid.toLowerCase())) {
            System.out.println("【"+outerTid+"】 outer_tid 不会 NullPointerException");
        }

    }

    @Test
    public void nullExp2() {
        Map<String, Object> map = new HashMap<>(6);
        String outerTid = map.get("outer_tid").toString();
        if (StrUtil.isEmpty(outerTid)) {
            System.out.printf("outer_tid NullPointerException");
        }
    }
}
