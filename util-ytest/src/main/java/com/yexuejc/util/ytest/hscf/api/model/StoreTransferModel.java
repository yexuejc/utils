package com.yexuejc.util.ytest.hscf.api.model;

import java.io.Serializable;

public class StoreTransferModel implements Serializable {
	private static final long serialVersionUID = 7103915453727555870L;
	/**
	 * 转移门店id
	 */
	private String storeId;
	/**
	 * 转移对象
	 */
	private String toEeId;
	/**
	 * 转移说明
	 */
	private String note;
	/**
	 * eeid
	 */
	private String eeid;

	public String getEeid() {
		return eeid;
	}

	public void setEeid(String eeid) {
		this.eeid = eeid;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
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
