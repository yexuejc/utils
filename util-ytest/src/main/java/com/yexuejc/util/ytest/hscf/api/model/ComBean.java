package com.yexuejc.util.ytest.hscf.api.model;

import java.io.Serializable;

public class ComBean implements Serializable{
	private static final long serialVersionUID = 2102104624866065092L;
	private Object name;
	private Object oldValue;
	private Object newValue;

	public ComBean(Object name, Object oldValue, Object newValue) {
		super();
		this.name = name;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public Object getName() {
		return name;
	}


	public void setName(Object name) {
		this.name = name;
	}


	public Object getOldValue() {
		return oldValue;
	}


	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}


	public Object getNewValue() {
		return newValue;
	}


	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}


	@Override
	public String toString() {
		return "ComBean [name=" + name + ", oldValue=" + oldValue + ", newValue=" + newValue + "]";
	}
}