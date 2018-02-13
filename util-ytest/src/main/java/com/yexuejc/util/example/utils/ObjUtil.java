package com.yexuejc.util.example.utils;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjUtil {

	static String exclude[] = new String[] { 
			"serialVersionUID"
			//car
			,"sn","id","ownerLabel","appraisePrice","level","lpnCity" 
			//store
			
	};

	/**
	 * 对比两个对象相同属性名的值是否一样
	 * 
	 * @param obj1
	 *            new
	 * @param obj2
	 *            old
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	@SuppressWarnings({ "rawtypes" })
	public static List<ComBean> comparison4KeyByValue(Object obj1, Object obj2)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		List<ComBean> list = new ArrayList<>();

		if (obj1 == null) {
			Class obj2Clazz = obj2.getClass();
			Field[] obj2fs = obj2Clazz.getDeclaredFields();
			for (Field obj2Pd : obj2fs) {
				obj2Pd.setAccessible(true);
				String name = obj2Pd.getName();// 属性名
				if (Arrays.asList(exclude).contains(name))
					continue;
				Object value2 = obj2Pd.get(obj2);
				addList(list, name, value2, "");
			}

		} else if (obj2 == null) {
			Class obj1Clazz = obj1.getClass();
			Field[] obj1fs = obj1Clazz.getDeclaredFields();
			for (Field obj1Pd : obj1fs) {
				obj1Pd.setAccessible(true);
				String name = obj1Pd.getName();// 属性名
				if (Arrays.asList(exclude).contains(name))
					continue;
				Object value1 = obj1Pd.get(obj1);
				addList(list, name, "", value1);
			}
		} else {

			Class obj1Clazz = obj1.getClass();
			Class obj2Clazz = obj2.getClass();

			Field[] obj1fs = obj1Clazz.getDeclaredFields();
			Field[] obj2fs = obj2Clazz.getDeclaredFields();
			// PropertyDescriptor[] obj1Pds =
			// Introspector.getBeanInfo(obj1Clazz,
			// Object.class).getPropertyDescriptors();
			// PropertyDescriptor[] obj2Pds =
			// Introspector.getBeanInfo(obj2Clazz,
			// Object.class).getPropertyDescriptors();

			for (Field obj1Pd : obj1fs) {
				obj1Pd.setAccessible(true);
				String name = obj1Pd.getName();// 属性名
				if (Arrays.asList(exclude).contains(name))
					continue;
				for (Field obj2Pd : obj2fs) {
					obj2Pd.setAccessible(true);
					String name2 = obj2Pd.getName();// 属性名
					if (name.equals(name2)) {// 有同名属性
						// Method readMethod = obj1Pd.getReadMethod();// get方法
						// Object value1 = readMethod.invoke(obj1);//
						// 调用get方法等同于获得obj1的属性值
						//
						// Method readMethod2 = obj2Pd.getReadMethod();// get方法
						// Object value2 = readMethod2.invoke(obj2);//
						// 调用get方法等同于获得obj2的属性值
						Object value1 = obj1Pd.get(obj1);
						Object value2 = obj2Pd.get(obj2);
						if (!equals(value2, value1)) {
							addList(list, name, value2, value1);
						}
						break;
					}
				}
			}
		}
		return list;
	}

	public static List<ComBean> addList(List<ComBean> list, String name, Object value2, Object value1) {
		ComBean comBean = new ComBean(name, value2, value1);
		list.add(comBean);
		return list;
	}

	public static class ComBean implements Serializable {
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

	static boolean equals(Object object, Object object2) {
		if (object == null && object2 == null) {
			return true;
		}
		if (object != null) {
			if (object instanceof Integer && object2 instanceof Integer) {
				if (object == object2) {
					return true;
				}
			} else if (object instanceof String && object2 instanceof String) {

				if (object.equals(object2)) {
					return true;
				}

			}
		}
		if (object == object2) {
			return true;
		}
		return false;
	}
	
	/***
	 * str转对象
	 * 使用map.tostring ---> obj
	 * @param str
	 * @return
	 */
	public static <T> T transformStr2Obj(String str){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(str,new TypeReference<T>(){});
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
