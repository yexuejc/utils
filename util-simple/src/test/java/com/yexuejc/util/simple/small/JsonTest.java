package com.yexuejc.util.simple.small;

import com.yexuejc.util.base.util.JsonUtil;

import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        JsonUtil.json2Obj("{\"name\":\"张三\"}", Map.class );
    }
}
