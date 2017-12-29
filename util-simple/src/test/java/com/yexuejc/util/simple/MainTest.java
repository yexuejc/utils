package com.yexuejc.util.simple;

import com.yexuejc.util.base.util.StrUtil;

/**
 * @PackageName: com.yexuejc.util.simple
 * @Description:
 * @author: maxf
 * @date: 2017/12/29 17:55
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println(StrUtil.genUUID());
        System.out.println(StrUtil.toMD5("123456"));
    }
}
