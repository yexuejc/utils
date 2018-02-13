package com.yexuejc.util.example.design_mode.single_factory;

/***
 * 工厂方法模式 
 * @author yexue
 * @expl 车的工厂类
 * @time 2017年8月31日 下午2:38:00
 */
public class CarFactory {
	private CarFactory() {
	}

	public static CarFactory getInstance() {
		return InnerCarDactory.carFactory;
	}

	private static class InnerCarDactory {
		static CarFactory carFactory = new CarFactory();
	}

	/**
	 * 以宝马和红旗为例
	 * 
	 * @param type
	 * @return
	 */
	public ICar createCar(String type) {
		if (type.equals("BaoMa")) {// 宝马
			return new BaoMaCar();
		} else if (type.equals("HongQi")) {
			return new HongQiCar();// 红旗
		} else {
			throw new RuntimeException();
		}
	}

}
