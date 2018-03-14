package com.yexuejc.util.ytest.hscf.api.model;

import java.io.Serializable;

public class Pager implements Serializable{
	private static final long serialVersionUID = 6994334969697627481L;
	
	/**
	 * 页码
	 */
	private int page = 1;
	
	/**
	 * 数据总条数
	 */
	private int counts = 0;
	
	/**
	 * 每页显示条数
	 */
	private int size = 10;

	public int getPages() {
		return (counts + size - 1) / size;
	}
	
	public int getFirstResult() {
		return (page - 1) * size;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

}
