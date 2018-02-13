package com.yexuejc.util.example.small;

public class PTest {
	public static void main(String[] args) {
		System.out.println("正的临界点127");
		Integer a = 127; Integer b = 127;
		System.out.println("127:"+(a==b));
		Integer c = 128; Integer d = 128;
		System.out.println("128:"+(c==d));
		System.out.println("===================");
		System.out.println("负的临界点-128");
		Integer a1 = -128; Integer b1 = -128;
		System.out.println("-128:"+(a1==b1));
		Integer c1 = -129; Integer d1 = -129;
		System.out.println("-129:"+(c1==d1));
	}

}
