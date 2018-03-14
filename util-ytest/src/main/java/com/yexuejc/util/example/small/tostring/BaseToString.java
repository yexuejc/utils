package com.yexuejc.util.example.small.tostring;

public class BaseToString {
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "BaseToString [a=" + a + "]";
	}
}
