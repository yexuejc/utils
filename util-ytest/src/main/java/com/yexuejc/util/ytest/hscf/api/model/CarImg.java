package com.yexuejc.util.ytest.hscf.api.model;

import java.io.Serializable;

/**
 * 图片信息
 * 
 * @author pengh
 *
 */
public class CarImg implements Serializable {

	private static final long serialVersionUID = 8641960490832364963L;

	/** 图片名称 */
	private String name;
	/** 图片类型 */
	private String type;
	/** 图片地址 */
	private String img;
	/** 是否敏感图片 */
	private String sensitive;

	public CarImg() {
	}

	public CarImg(String name, String type, String img, String sensitive) {
		this.name = name;
		this.type = type;
		this.img = img;
		this.sensitive = sensitive;
	}

	public String getSensitive() {
		return sensitive;
	}

	public void setSensitive(String sensitive) {
		this.sensitive = sensitive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
