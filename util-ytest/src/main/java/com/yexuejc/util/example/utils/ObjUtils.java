package com.yexuejc.util.example.utils;

/**
 * obj处理工具类
 * 
 * @author yexue
 * @expl
 * @time 2017年11月8日 下午2:56:26
 */
public class ObjUtils {
	/**
	 * 转换string 简单封装
	 * @param object
	 * @return
	 */
	public static String getString(Object object) {
		return object == null ? "" : object.toString();
	}

}
