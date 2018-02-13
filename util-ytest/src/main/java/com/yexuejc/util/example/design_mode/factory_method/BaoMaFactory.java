package com.yexuejc.util.example.design_mode.factory_method;

/**
 * 工厂方法模式 
 *	单例模式
 * @author yexue
 * @expl 宝马工厂:该工厂唯一 
 * @time 2017年8月31日 下午4:15:04
 */
public class BaoMaFactory implements IFactory{
	private BaoMaFactory(){}
	public static BaoMaFactory getInstance(){
		return InnerBaoMaFactory.baoMaFactory;
	}
	private static class InnerBaoMaFactory{
		private static BaoMaFactory baoMaFactory = new BaoMaFactory();
	}

	@Override
	public ICar createCar() {
		return new BaoMaCar();
	}

}
