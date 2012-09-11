package ch16.ex16_05;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.ArrayList;
import ch16.ex16_02.TypeDesc;

public class ClassContents {
	
	public static void printAllMembers(Class<?> c){
		System.out.println(c);
		printMembers(c.getDeclaredFields());
		printMembers(c.getDeclaredConstructors());
		printMembers(c.getDeclaredMethods());
        Annotation[] a = c.getAnnotations();
        for(int i = 0; i < a.length; i++)
        	System.out.println(a[i].toString());
	}
	
	private static void printMembers(Member[] mems){
		for(Member m : mems){
			if(m.getDeclaringClass() == Object.class){
				continue;
			}
			String decl = m.toString();
			System.out.println(strip(decl, "JPL.ch16.ex16_5"));
		}
	}
	
	private static String strip(String str, String clearedStr){
		if(str.contains(clearedStr)){
			return str.replace(clearedStr, "");
		}
		else{
			return str;
		}
	}
	
	public static void main(String[] args) {
		Class<?> c;
		ArrayList classList = null;
		try {
			c = Class.forName(args[0]);
			TypeDesc desc = new TypeDesc();
			for(String name : args){
				desc.printType(c, 0, TypeDesc.basic);
				classList = desc.getClassList();	
			}
			for(int i = 0; i < classList.size(); i++){
				printAllMembers((Class<?>) classList.get(i));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class:" + args[0]);
		}
	}

}
