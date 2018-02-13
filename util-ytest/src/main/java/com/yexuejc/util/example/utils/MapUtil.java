package com.yexuejc.util.example.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yexuejc.util.ytest.utils.StrUtil;

public class MapUtil {
	/**
	 * map中的key装换为子map
	 * 
	 * @param map
	 * @param keys
	 *            key[]
	 * @return
	 */
	public static Map<String, Object> obj2Map(Map<String, Object> map, String... keys) {
		for (String key : keys) {
			map = obj2Map(map, key);
		}
		return map;
	}

	/**
	 * map中的key装换为子map
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public static Map<String, Object> obj2Map(Map<String, Object> map, String key) {
		Object object = (Object) map.get(key);
		if (StrUtil.isNotEmpty(object)) {
			if (object.toString().indexOf("[") == 0) {
				List<Map<String, Object>> list = string2List(object.toString());
				if (list != null) {
					map.put(key, list);
				}
			} else {
				Map<String, Object> m = string2Map(object.toString());
				if (m != null) {
					map.put(key, m);
				}
			}
		}
		return map;
	}

	/**
	 * 字符串装换为map
	 * 
	 * @param str
	 * @return
	 */
	public static Map<String, Object> string2Map(String str) {
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> m = null;
		try {
			m = mapper.readValue(str, new TypeReference<HashMap<String, Object>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
			m = null;
		}
		return m;
	}

	/**
	 * 字符串装换为map
	 * 
	 * @param str
	 * @return
	 */
	public static List<Map<String, Object>> string2List(String str) {
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> list = null;
		try {
			list = mapper.readValue(str, new TypeReference<List<HashMap<String, Object>>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}

}
