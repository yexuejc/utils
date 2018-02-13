package com.yexuejc.util.ytest.hscf.api.model;

/**
 * 车辆基本信息
 * 
 * @author pengh
 *
 */
public class CarInfoModel {

	/** 车主称谓 */
	private String ownerFamilyName;
	
	/** 车主性别   如：先生，女士  */
	private String ownerLabel;
	
	/** 年检到期日 */
	private String certExpire;
	
	/** 交强险到期日 */
	private String liabilityExpire;
	
	/** 商业险到期日 */
	private String insuranceExpire;
	
	/** 过户次数 */
	private int transferTimes;
	
	/** 车辆描述（车主自述） */
	private String desc;

	public String getOwnerLabel() {
		return ownerLabel;
	}

	public void setOwnerLabel(String ownerLabel) {
		this.ownerLabel = ownerLabel;
	}

	public String getOwnerFamilyName() {
		return ownerFamilyName;
	}

	public void setOwnerFamilyName(String ownerFamilyName) {
		this.ownerFamilyName = ownerFamilyName;
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

	public int getTransferTimes() {
		return transferTimes;
	}

	public void setTransferTimes(int transferTimes) {
		this.transferTimes = transferTimes;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
