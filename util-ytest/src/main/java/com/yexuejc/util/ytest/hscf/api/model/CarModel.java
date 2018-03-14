package com.yexuejc.util.ytest.hscf.api.model;

import com.yexuejc.util.base.util.StrUtil;

import java.util.List;


/**
 * 二手车对象
 * 
 * @author yexue
 * @expl
 * @time 2017年9月20日 上午10:24:59
 * @version 1.0
 */
public class CarModel {

	private String id;

	/** 车架号 */
	@Deprecated
	private String vin;

	/** detailId */
	private String detailId;

	/** 二手车所在城市 */
	private String city;

	/** 二手车行驶里程数 */
	private String mileage;

	/** 二手车信息 */
	/** 年检到期日 */
	private String certExpire;

	/** 交强险到期日 */
	private String liabilityExpire;

	/** 二手车颜色 */
	private String color;

	/** 卖家期望价格 */
	private String vendorPrice;

	/** 二手车所属人名字 */
	@Deprecated
	private String ownerName;

	/** 二手车所属人电话 */
	@Deprecated
	private String mobile;

	/*** 选填信息 *****************************************************************************/

	/** 二手车车牌 */
	@Deprecated
	private String lpn;

	/** 商业险到期日 */
	private String insuranceExpire;

	/** 过户次数 */
	private String transferTimes;

	/** 二手车价格 */
	private String price;

	/** 二手车标签 */
	private String[] labels;

	/** 是否需要检测 */
	private String test;

	/** 是否需要评估 */
	private String assess;

	/** 二手车描述 */
	private String desc;

	/** 二手车图片 */
	private List<CarImg> carImgs;

	// 对应info数据
	private CarInfoModel carInfo;

	/** 敏感信息 */
	private CarSensitive cst;

	/** 车辆归属 */
	private Integer belongType;

	private String storeId;

	/** 请求类型 */
	private Integer reqType;

	/** 评估师给出的评估价格 */
	private String appraisePrice;

	/** 二手车上牌时间 */
	private String regDate;

	/** 车主称谓 */
	private String ownerLabel;

	/** 二手车等级 */
	private String level;

	// 检测师Id
	private String detectorId;

	// 评估师Id
	private String appraiserId;

	// 业务员Id
	private String repId;

	// 车辆sn
	private String sn;

	// 车辆车牌所在地Code
	private String lpnCity;

	// 操作数据的user_int_id
	private String opId;

	public Integer getBelongType() {
		return belongType;
	}

	public void setBelongType(Integer belongType) {
		this.belongType = belongType;
	}

	public Integer getReqType() {
		return reqType;
	}

	public void setReqType(Integer reqType) {
		this.reqType = reqType;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getOpId() {
		return opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	public String getLpnCity() {
		return lpnCity;
	}

	public void setLpnCity(String lpnCity) {
		this.lpnCity = lpnCity;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getAssess() {
		return assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	public CarSensitive getCst() {
		return cst;
	}

	public void setCst(CarSensitive cst) {
		this.cst = cst;
	}

	public String getOwnerLabel() {
		return ownerLabel;
	}

	public void setOwnerLabel(String ownerLabel) {
		this.ownerLabel = ownerLabel;
	}

	@Deprecated
	public String getVin() {
		return vin;
	}

	@Deprecated
	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetectorId() {
		return detectorId;
	}

	public void setDetectorId(String detectorId) {
		this.detectorId = detectorId;
	}

	public String getAppraiserId() {
		return appraiserId;
	}

	public void setAppraiserId(String appraiserId) {
		this.appraiserId = appraiserId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCertExpire() {
		return certExpire;
	}

	public void setCertExpire(String certExpire) {
		this.certExpire = certExpire;
	}

	public String getLiabilityExpire() {
		return liabilityExpire;
	}

	public void setLiabilityExpire(String liabilityExpire) {
		this.liabilityExpire = liabilityExpire;
	}

	public String getInsuranceExpire() {
		return insuranceExpire;
	}

	public void setInsuranceExpire(String insuranceExpire) {
		this.insuranceExpire = insuranceExpire;
	}

	public String getTransferTimes() {
		return transferTimes;
	}

	public void setTransferTimes(String transferTimes) {
		this.transferTimes = transferTimes;
	}

	@Deprecated
	public String getLpn() {
		return lpn;
	}

	@Deprecated
	public void setLpn(String lpn) {
		this.lpn = lpn;
	}

	public String getAppraisePrice() {
		return appraisePrice;
	}

	public void setAppraisePrice(String appraisePrice) {
		this.appraisePrice = appraisePrice;
	}

	public String getVendorPrice() {
		return vendorPrice;
	}

	public void setVendorPrice(String vendorPrice) {
		this.vendorPrice = vendorPrice;
	}

	public CarInfoModel getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(CarInfoModel carInfo) {
		this.carInfo = carInfo;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getRepId() {
		return repId;
	}

	public void setRepId(String repId) {
		this.repId = repId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<CarImg> getCarImgs() {
		return carImgs;
	}

	public void setCarImgs(List<CarImg> carImgs) {
		this.carImgs = carImgs;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Integer getMileage() {
		return mileage == null ? null : StrUtil.isNumeric(mileage) ? Integer.valueOf(mileage) : -1;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Deprecated
	public String getOwnerName() {
		return ownerName;
	}

	@Deprecated
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Deprecated
	public String getMobile() {
		return mobile;
	}

	@Deprecated
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
