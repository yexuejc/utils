package com.yexuejc.util.example.small;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayLenghtTest {

	private static Logger logger = LoggerFactory.getLogger(ArrayLenghtTest.class);

	public static void main(String[] args) {
		String str = "a,b,c,,";
		String[] ary = str.split(",");
		// 预期大于 3，结果是 3
		System.out.println(ary.length);

		String str2 = "start";
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(str2);
		for (int i = 0; i < 100; i++) {
			stringBuilder.append("hello");
		}
		str2 = stringBuilder.toString();
		System.out.println(str2);

		List<String> list = new ArrayList<String>(2);
		list.add("guan");
		list.add("bao");
		String[] array = new String[list.size()];
		array = list.toArray(array);
		System.out.println(array);
		List<Integer> list2 = new ArrayList<>();
		list2.add(10);
		list2.add(15);
		Integer[] intArray = new Integer[list2.size()];
		intArray = list2.toArray(intArray);
		System.out.println(intArray);

		/**
		 * 使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方 法，它的 add/remove/clear
		 * 方法会抛出 UnsupportedOperationException 异常。 ：asList 的返回对象是一个 Arrays
		 * 内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适配器模式，只是转换接口，后台的数据仍是数组。
		 */
		String[] str3 = new String[] { "you", "wu" };
		List list3 = Arrays.asList(str3);
		// list3.add("yangguanbao");
		System.out.println(list3.get(0));
		str3[0] = "gujin";// list.get(0)也会随之修改。
		System.out.println(list3.get(0));

		List<String> list4 = new ArrayList<String>();
		list4.add("1");
		list4.add("2");
		list4.add("1");
		list4.add("3");
		list4.add("1");
		/**
		 * <pre>
		 * ******************* 以下代码错误 *************************************
		
		for (String item : list4) {
			if ("1".equals(item)) {
				list4.remove(item);
			}
		}
		 * </pre>
		 */
		/********************* 以下代码正确 **************************************/
		Iterator<String> iterator = list4.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			if ("1".equals(item)) {
				iterator.remove();
			}
		}
		System.out.println(list4.size());

		Map<String, String> map = new HashMap<>(5);
		map.put("1", "1v");
		map.put("2", "2v");
		map.put("3", "3v");
		map.put("4", "4v");
		map.put("5", "5v");
		System.out.println(map);
		/**
		 * 推荐：java8以下
		 */
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key:" + key + ";value:" + value);
		}
		/**
		 * 不推荐：遍历了2次
		 */
		for (String dataKey : map.keySet()) {
			System.out.println(dataKey + ":" + map.get(dataKey));
		}
		/**
		 * 推荐：java8支持
		 */
		map.forEach((k, v) -> {
			System.out.println("key : " + k + "; value : " + v);
		});

		System.out.println(Instant.now().atOffset(ZoneOffset.ofHours(8)));
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(Instant.now().atOffset(ZoneOffset.ofHours(8))));

		double d = Math.random();
		int a = new Random().nextInt(100);

		System.out.println(d + ":" + a);
		/// asasas
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		// DTO
		System.out.println("ArrayLenghtTest_info_syso:xxxxx");
		if (logger.isDebugEnabled()) {
			// TODO faild
			logger.debug("Processing trade with id: " + d + " and symbol: " + a);
		}
		if (logger.isInfoEnabled()) {
			logger.info("ArrayLenghtTest_info_run:{} and symbol:{} ", d, a);
		}
		
		/**
		 * <pre>
		 * expression1->boolean
		 * expression2->输出信息
		 * 1. assert expression1;
		   2. assert expression1: expression2;
		   </pre>
		 */
		//assert a<0:"sss";
		assert d<0;
		
	}
}
