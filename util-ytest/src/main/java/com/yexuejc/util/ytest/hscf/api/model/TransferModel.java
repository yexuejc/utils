package com.yexuejc.util.ytest.hscf.api.model;

import java.io.Serializable;

public class TransferModel implements Serializable{
	private static final long serialVersionUID = 2804942034948869444L;
	/**
	 * 转移车辆id
	 */
	private String carId;
	/**
	 * 转移对象
	 */
	private String toEeId;
	/**
	 * 转移说明
	 */
	private String note;
	private String eeid;

	public String getEeid() {
		return eeid;
	}

	public void setEeid(String eeid) {
		this.eeid = eeid;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getToEeId() {
		return toEeId;
	}

	public void setToEeId(String toEeId) {
		this.toEeId = toEeId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
