package com.yexuejc.util.example.small;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 直接newMap {
	public static void main(String[] args) {
		List<Map<String, Object>> maps = new ArrayList<>();
		List<Map<String, Object>> maps2 = new ArrayList<>();
		long s = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			final int a = i;
			maps.add(new HashMap<String, Object>() {
				private static final long serialVersionUID = 1L;

				{
					put(a + "-->", a);
				}
			});
		}
		long t = System.currentTimeMillis();
		System.out.println(t - s);
		t = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			final int a = i;
			Map<String, Object> map = new HashMap<>();
			map.put(a + "-->", a);
			maps2.add(map);
		}
		long e = System.currentTimeMillis();
		System.out.println(e - t);
	}

}
