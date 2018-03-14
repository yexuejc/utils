package com.yexuejc.util.example.design_mode.single;

/***
 * 标准的单例模式
 * 
 * @author yexue
 * @expl
 * @time 2017年8月30日 下午2:16:06
 */
public class InnserCriteriaSingleton {

	public Singleton getInstance() {
		return Singleton.singleton;
	}

	private static class Singleton {
		static Singleton singleton = new Singleton();
	}

}

/**
 * 上面写法变种：更符合习惯
 * @author yexue
 * @expl
 * @time 2017年8月30日 下午2:22:34
 */
class Singleton2 {
	private Singleton2() {
	}

	public Singleton2 getInstance() {
		return SingletonInstance.singleton;
	}

	private static class SingletonInstance {
		static Singleton2 singleton = new Singleton2();
	}
}
