package com.yexuejc.util.example.design_mode.factory_method;

/**
 * 工厂方法模式 
 * @author yexue
 * @expl 红旗工厂
 * @time 2017年8月31日 下午4:15:04
 */
public class HongQiFactory implements IFactory{

	@Override
	public ICar createCar() {
		return new HongQiCar();
	}

}
