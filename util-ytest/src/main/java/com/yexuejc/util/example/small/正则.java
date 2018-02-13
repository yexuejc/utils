package com.yexuejc.util.example.small;

import java.util.regex.Pattern;

public class 正则 {
	public static void main(String[] args) {
		String pattern = "^$|[\\w !@#$%^&*()+-=/ `~？]+$";
		String content = "o)o";
		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println(isMatch);
	}

}
