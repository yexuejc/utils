package com.yexuejc.util.example.design_mode.single_factory;

public class Test {
	public static void main(String[] args) {
		CarFactory.getInstance();
		/**
		 * 需求：我要一辆宝马
		 * 实现：调用汽车工厂生产宝马
		 */
		ICar car = CarFactory.getInstance().createCar("BaoMa");
		System.out.println(car.biaozhi());
	}

}
