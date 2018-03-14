package com.yexuejc.util.example.bean;

import java.io.Serializable;

/**
 * 基类 vo
 * 
 * @author yexue
 * @expl
 * 
 *       <pre>
 *     VO:value object值对象
 *        ViewObject表现层对象 
 *        主要对应界面显示的数据对象。
 *        对于一个WEB页面，或者SWT、SWING的一个界面，用一个VO对象对应整个界面的值。
 * 
 *       <pre>
 * @time 2017年11月8日 上午11:11:54
 */
public class BaseVO implements Serializable {

	private static final long serialVersionUID = -7679296673189336136L;

	public static interface Add {
	}

	public static interface Del {
	}

	public static interface Mdfy {
	}

	public static interface Srch {
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
