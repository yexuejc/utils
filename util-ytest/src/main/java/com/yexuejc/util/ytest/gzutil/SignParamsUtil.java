
package com.yexuejc.util.ytest.gzutil;

import com.yexuejc.util.ytest.gzutil.MD5Util;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SignParamsUtil {
    private SignParamsUtil() {
    }

    public static Map<String, Object> createSignMap(Map<String, ?> map, String mark) {
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(map);
        treeMap.put("signMark", mark);
        Iterator iterator = treeMap.values().iterator();
        StringBuilder stringBuilder = new StringBuilder();

        while(iterator.hasNext()) {
            Object temp = iterator.next();
            if (temp == null) {
                stringBuilder.append("");
            } else {
                stringBuilder.append(temp.toString());
            }
        }

        String md5 = MD5Util.MD5Encode(stringBuilder.toString(), "utf-8");
        treeMap.put("signPwd", md5);
        treeMap.remove("signMark");
        return treeMap;
    }
}
