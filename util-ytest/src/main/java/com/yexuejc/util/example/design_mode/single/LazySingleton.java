package com.yexuejc.util.example.design_mode.single;

/***
 * 懒汉模式
 *  该模式使用不牵涉其他静态域
 * @author yexue
 * @expl
 * @time 2017年8月30日 下午2:24:44
 */
public class LazySingleton {
	private LazySingleton() {
	}

	private static LazySingleton lazySingleton = new LazySingleton();

	public LazySingleton getInstance() {
		return lazySingleton;
	}

}
