package com.yexuejc.util.example.small;

/**
 * 静态内部类的优点：降低包的深度，不受外部类实例影响
 * 非静态内部类优点：可以自由使用外部类的所有变量和方法
 * @author yexue
 * @expl
 * @time 2017年9月1日 上午11:33:29
 */
public class StaticTest {
	public static void main(String[] args) {
		Test2.TestSub1 sub1 = new Test2().new TestSub1();
		Test2.TestSub2 sub2 = new Test2.TestSub2();
		Test2.TestSub1 sub11 = Test2.getInstance().new TestSub1();
		Test2.TestSub1 sub12 = Test2.getInst().new TestSub1();
		/**
		 * <p>
		 * err 与 out
		 * err:标准错误输出，没有缓存，及时输出
		 * out:标准输出，带缓存
		 * 现象：下面例子中,out按顺序输出，err不一定
		 * </p>
		 */
		System.out.println("start...");
		System.err.println("middle...");
		System.out.println("end...");
	}

}

class Test2 {
	
	class TestSub1 {
		public String getA() {
			return a;
		}
		public String getB() {
			return b;
		}

	}

	static class TestSub2 {
		public String getA() {
			return a;
		}
		//BAD
//		public String getB() {
//			return b;
//		}

	}
	
	TestSub2 getTestSub2(){
		return new TestSub2();
	}

	static String a = "aaaa";
	String b = "bbbb";

	/**
	 * 单例模式
	 * @return
	 */
	public static Test2 getInst() {
		return InnerInstance.test2;
	}

	static class InnerInstance {
		static Test2 test2 = new Test2();
	}

	/**
	 * 懒汉模式，不建议写在有静态属性的类里面
	 */
	private static Test2 INSTANCE = new Test2();

	public static Test2 getInstance() {
		return INSTANCE;
	}
}
