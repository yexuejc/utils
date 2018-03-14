package com.yexuejc.util.example.design_mode.factory_method;

public class Test {
	public static void main(String[] args) {
		/**
		 * 需求：我要一辆宝马和一辆红旗
		 * 实现：找宝马工厂生产宝马车，找红旗工厂生产红旗车
		 */
		ICar car  = BaoMaFactory.getInstance().createCar();
		System.out.println(car.biaozhi());
		IFactory factory = new HongQiFactory();
		car = factory.createCar();
		System.out.println(car.biaozhi());
	}

}
