package com.yexuejc.util.example.small;

import java.lang.reflect.Field;

public class ReflectField {
	public static void main(String[] args) {
		A n = new ReflectField().new A();
		n.a = 1;
		Class obj2Clazz = n.getClass();
		Field[] obj2fs = obj2Clazz.getDeclaredFields();
		for (Field obj2Pd : obj2fs) {
			obj2Pd.setAccessible(true);
			
			System.out.println(">>>>>>>>>>>>>>>");
			if(obj2Pd.getType()==Integer.class)System.out.println("sssssssssssss");
			if(obj2Pd.getType()==int.class)System.out.println("ffffffffffffffffff");
			System.out.println(obj2Pd.getName());
			System.out.println(obj2Pd.getType());
			System.out.println(obj2Pd.getGenericType());
		}
	}
	
	class A{
		private int a;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}
	}
}
