package com.yexuejc.util.example.small.tostring;

public class Tostring extends BaseToString {
	private String b;

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Tostring [b=" + b + ", toString()=" + super.toString() + "]";
	}

}
