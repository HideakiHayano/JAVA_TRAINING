package ch16.ex16_03;

import java.lang.reflect.Member;
import java.util.ArrayList;

import ch16.ex16_02.TypeDesc;
import ch03.ex03_09.Vehicle;

public class ClassContents {
	
	public static void printAllMembers(Class<?> c){
		System.out.println(c);
		printMembers(c.getDeclaredFields());
		printMembers(c.getDeclaredConstructors());
		printMembers(c.getDeclaredMethods());
	}
	
	private static void printMembers(Member[] mems){
		for(Member m : mems){
			if(m.getDeclaringClass() == Object.class){
				continue;
			}
			String decl = m.toString();
			System.out.println(" ");
			System.out.println(strip(decl, "JPL.ch6.ex6_5."));
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
		//Please input the value of "String[] args" from the settings of Java application.
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
