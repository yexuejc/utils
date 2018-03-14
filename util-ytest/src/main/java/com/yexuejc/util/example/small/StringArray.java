package com.yexuejc.util.example.small;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class StringArray {
	public static void main(String[] args) {
		String [] a = new String[]{"J"};
		List<String>strings = new ArrayList<>();
		strings.add("J");
		System.out.println(new Gson().toJson(strings));
		
		
		
		String b=a.toString(); 
		System.out.println(new Gson().toJson(a));
		System.out.println(b);
		Object object = a;
		System.out.println(new Gson().toJson(object));
	}

}
