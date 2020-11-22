package reflection;

import java.lang.reflect.Constructor;

import charactor.Hero;

public class CreateObjectByReflection {
	public static void main(String[]args) {
		Hero h1=new Hero();
		h1.name="teemo";
		System.out.println(h1);
		
		try {
			//使用反射机制创建对象
			String className="charactor.Hero";
			//类对象
			Class pClass=Class.forName(className);
			//构造器
			Constructor c=pClass.getConstructor();
			//通过构造器初始化
			Hero h2=(Hero)c.newInstance();
			h2.name="gareen";
			System.out.println(h2);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
