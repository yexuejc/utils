package com.yexuejc.util.example.bean;

/**
 * 广告对应页面数据
 * 
 * @author yexue
 * @expl
 * @time 2017年11月8日 上午11:30:55
 */
public class BannerVO extends BaseVO {
	public BannerVO() {};

	public BannerVO(String title, String imgPath, String targetUrl) {
		this.title = title;
		this.imgPath = imgPath;
		this.targetUrl = targetUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	@Override
	public String toString() {
		return "BannerVO [title=" + title + ", imgPath=" + imgPath + ", targetUrl=" + targetUrl + "]";
	}
	private static final long serialVersionUID = 5426112683368322997L;
	/**
	 * 名称-->banner_name
	 */
	private String title;
	/**
	 * 图片地址-->img_path
	 */
	private String imgPath;
	/**
	 * 链接地址-->target_url
	 */
	private String targetUrl;
}
