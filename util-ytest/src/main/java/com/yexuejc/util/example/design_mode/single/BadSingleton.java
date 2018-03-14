package com.yexuejc.util.example.design_mode.single;

/***
 * 单例模式 v2
 * 
 * @author yexue
 * @expl http://www.cnblogs.com/zuoxiaolong/p/pattern2.html
 * @time 2017年8月30日 下午12:03:06
 */
public class BadSingleton {
	private BadSingleton() {
	}

	private static BadSingleton INSTANCE;
	//如此写法+双重同步锁也是可以的
	//private static volatile BadSingleton INSTANCE;

	/**
	 * 加同步锁-在一个线程访问这个方法时，其它所有的线程都要处于挂起等待状态-浪费时间
	 * @return
	 */
	public static synchronized BadSingleton getInstance() {
		if (INSTANCE == null)
			INSTANCE = new BadSingleton();
		return INSTANCE;
	}

	/**
	 * 双重同步锁
	 * 
	 * @return
	 */
	public static BadSingleton getSynchronizedInstance() {
		if (INSTANCE == null)
			synchronized (BadSingleton.class) {
				if (INSTANCE == null)
					INSTANCE = new BadSingleton();
			}
		return INSTANCE;
	}

}
