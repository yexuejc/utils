package com.yexuejc.util.ytest.hscf.api.model;

import java.io.Serializable;
import java.util.List;

public class StoreModel implements Serializable{

	private static final long serialVersionUID = -3909985583609913850L;

	private String name;

	private String imgs;

	private String isHc;

	private String city;

	private String addr;

	/** 市场id */
	private String bazaarId;

	private String adName;

	private String adMobile;

	private String adPost;

	private List<MoreAd> moreAd;

	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String getIsHc() {
		return isHc;
	}

	public void setIsHc(String isHc) {
		this.isHc = isHc;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBazaarId() {
		return bazaarId;
	}

	public void setBazaarId(String bazaarId) {
		this.bazaarId = bazaarId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdMobile() {
		return adMobile;
	}

	public void setAdMobile(String adMobile) {
		this.adMobile = adMobile;
	}

	public String getAdPost() {
		return adPost;
	}

	public void setAdPost(String adPost) {
		this.adPost = adPost;
	}

	public List<MoreAd> getMoreAd() {
		return moreAd;
	}

	public void setMoreAd(List<MoreAd> moreAd) {
		this.moreAd = moreAd;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
