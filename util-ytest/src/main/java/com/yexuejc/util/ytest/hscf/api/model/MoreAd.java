package com.yexuejc.util.ytest.hscf.api.model;

import java.io.Serializable;

/**
 * 备用联系人
 * @author yexue
 * @expl
 * @time 2017年9月5日 上午11:09:27
 */
public class MoreAd implements Serializable{

	private static final long serialVersionUID = 4477920427334987564L;
	
	/**
	 * 名片
	 */
	private String img;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 联系电话
	 */
	private String mobile;
	/**
	 * 职务
	 */
	private String post;
	
	public MoreAd() {
	}
	public MoreAd(String img, String name, String mobile, String post) {
		super();
		this.img = img;
		this.name = name;
		this.mobile = mobile;
		this.post = post;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}

}
