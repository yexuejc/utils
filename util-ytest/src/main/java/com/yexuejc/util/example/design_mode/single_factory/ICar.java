package com.yexuejc.util.example.design_mode.single_factory;

/**
 * 简单工厂模式
 * 
 * @author yexue
 * @expl 车模型
 * @time 2017年8月31日 下午2:36:52
 */
public interface ICar {
	/**
	 * 车标
	 */
	public String biaozhi();
	//其他车的属性
	//车门、大灯、玻璃、座位、轮胎、发动机....

}
