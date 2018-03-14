package com.yexuejc.util.example.small;

import com.yexuejc.util.example.utils.ObjUtil;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class ListCompare {
	
	public static void main(String[] args) {
String a ="[{\"id\":\"156748946\",\"img\":\"img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg\",\"name\":\"赵六\",\"post\":\"看门的小伙\",\"mobile\":\"13512345678\"},{\"id\":\"23452452\",\"img\":\"img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg\",\"name\":\"赵六哥\",\"post\":\"看门的\",\"mobile\":\"13512345378\"},{\"id\":\"25115644\",\"img\":\"img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg\",\"name\":\"赵六弟\",\"post\":\"看门的\",\"mobile\":\"13512344378\"}]";
String b ="[{\"id\":\"156748946\",\"img\":\"img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg\",\"name\":\"赵六\",\"mobile\":\"13512345678\",\"post\":\"看门的小伙\"},{\"id\":\"23452452\",\"img\":\"img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg\",\"name\":\"赵六哥\",\"mobile\":\"13512345378\",\"post\":\"看门的\"},{\"id\":\"25115644\",\"img\":\"img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg\",\"name\":\"赵六弟\",\"mobile\":\"13512344378\",\"post\":\"看门的\"}]";
	}
	
	public static void main2(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		Entity entity1 = new ListCompare().new Entity("12454","张三", "156485464");
		Entity entity2 = new ListCompare().new Entity("124546","李四", "156461");
		Entity entity3 = new ListCompare().new Entity("124546","王五", "156461");
		
		
		List<Entity> list = new ArrayList<>();//数据库
		list.add(entity1);
		list.add(entity2);
		Entity[] arr = new Entity[]{entity3,entity1};//前端
		
		
		
		
		for (Entity entity : arr) {//z
			for (Entity e : list) {
				if(e.getId().equals(entity.getId())) {
					for (ObjUtil.ComBean subComBean : ObjUtil.comparison4KeyByValue(e, entity)) {
						System.out.println(subComBean.toString());
					}
				}
			}
		}
		
	}
	class Entity implements Serializable {
		private static final long serialVersionUID = 6567269211395502216L;
		private String id;
		private String name;
		private String desc;


		public Entity(String id, String name, String desc) {
			super();
			this.id = id;
			this.name = name;
			this.desc = desc;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		@Override
		public String toString() {
			return "Entity [id=" + id + ", name=" + name + ", desc=" + desc + "]";
		}

	}
}
