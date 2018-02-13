package com.yexuejc.util.example.small;

public class Trim {
	public static void main(String[] args) {
		String a = "app/15066525689228370.jpg, app/15066525866735191.png, app/15066525917737969.jpg, app/1506652597633223.png, app/15066526025681394.png";
		System.out.println(a.replaceAll(" ", ""));
	}

}
