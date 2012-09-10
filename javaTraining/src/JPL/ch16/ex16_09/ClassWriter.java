package JPL.ch16.ex16_09;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public class ClassWriter {
	
	public static void main(String[] args) {
		ClassWriter cw = new ClassWriter();
		Class<?> cls = cw.getClass("JPL.ch16.ex16_09.Something$Node");
		cw.printClass(cls);
		System.out.println("{");
		cw.printFields(cls);
		System.out.println("}");
		
		System.out.println("--------------------------------------------");
		Class<?> cls2 = cw.getClass("JPL.ch16.ex16_09.Something");
		cw.printClass(cls2);
		System.out.println("{");
		cw.printFields(cls2);
		System.out.println("}");
	}
	
	public Class<?> getClass(String name){
		StringBuffer tempMessage = new StringBuffer(); 
		Class<?> cls = null;
		try {
			cls = Class.forName(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			tempMessage.append("ClassNotFoundException\r\n");
		}
		return cls;
	}
	
	public void printClass(Class<?> cls){
		StringBuffer message = new StringBuffer();
		message.append(cls.getPackage() + "\r\n");
		printClass(cls, message);
		message.append(cls.getSimpleName());
		printGeneric(cls, message);
		printSuperClass(cls, message);
		printInterfaces(cls, message);
		for(Class<?> innerClass : cls.getClasses()){
			System.out.printf("InnerClass: %s, %s\n", innerClass,
					Modifier.toString(innerClass.getModifiers()));
		}

		System.out.println(message.toString());
	}
	
	public void printFields(Class<?> c){
		Field[] declaredfields = c.getDeclaredFields();
		Field[] fields = c.getFields();
		ArrayList<Field> fieldList = new ArrayList<Field>(fields.length); 
		for(int i = 0; i < fields.length; i++){
			fieldList.add(fields[i]);
		}
		for(int i = 0; i < declaredfields.length; i++){
			if(!fieldList.contains(declaredfields[i])){
				fieldList.add(declaredfields[i]);
			}
		}
		Field[] allFields = new Field[fieldList.size()];
		for(int i = 0; i < allFields.length; i++){
			allFields[i] = fieldList.get(i);
		}
		printMembers(allFields);
	}
	
	public void printMembers(Member[] mems){
		for(Member m : mems){
			System.out.println("\t" + m.toString() + "\r\n");
		}
	}
	
	public StringBuffer printClass(Class<?> cls, StringBuffer message){
		int mod = cls.getModifiers();
		
		if(Modifier.isPrivate(mod)){
			message.append("private ");
		}
		if(Modifier.isProtected(mod)){
			message.append("protected ");
		}
		if(Modifier.isPublic(mod)){
			message.append("public ");
		}
		if(Modifier.isStatic(mod)){
			message.append("static ");
		}
		if(Modifier.isFinal(mod)){
			message.append("final ");
		}
		if(Modifier.isAbstract(mod)){
			message.append("abstract ");
		}
		if(Modifier.isInterface(mod)){
			message.append("interface ");
		}
		if(Modifier.isNative(mod)){
			message.append("native ");
		}
		
		if(cls.isAnnotation()){
			message.append("interface@ ");
		}
		else if(cls.isEnum()){
			message.append("enum ");
		}
		else if(cls.isInterface()){
			message.append("interface ");
		}
		else {
			message.append("class ");
		}
		return message;
	}
	
	public StringBuffer printGeneric(Class<?> cls, StringBuffer message){
		TypeVariable<?>[] params = cls.getTypeParameters();
		if(params.length > 0){
			message.append('<');
			for(int i = 0; i < params.length; i++){
				message.append(params[i].getName());
				if(i != params.length - 1){
					message.append(", ");
				}
			}
			message.append(">");
		}
		else 
			message.append("");
		
		return message;
	}
	
	public StringBuffer printSuperClass(Class<?> cls, StringBuffer message){
		if(cls.getSuperclass() != null && !cls.getSuperclass().equals(Object.class)){
			message.append(" extends " + cls.getSuperclass().getSimpleName());
		}
		return message;
	}
	
	public StringBuffer printInterfaces(Class<?> cls, StringBuffer message){
		if(cls.getInterfaces() != null){
			Class[] iArray = cls.getInterfaces();
			
			for(int i = 0; i < iArray.length; i++){
				if(iArray[0] != null && i == 0){
					message.append(" implements ");
				}
				message.append(iArray[i].getSimpleName());
				if(i != iArray.length-1){
					message.append(", ");
				}
			}
			
		}
		return message;
	}
	
}