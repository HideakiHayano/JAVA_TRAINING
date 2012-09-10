package JPL.ch16.ex16_02;

import java.lang.reflect.*;
import java.util.ArrayList;

import JPL.ch06.ex06_05.ColorOfTrafficLight;

public class TypeDesc {
	private ArrayList list = new ArrayList();
	
	public ArrayList getClassList(){
		return (ArrayList) list.clone();
	}
	
	//�W���o��
	private java.io.PrintStream out = System.out;
	
	//�^���Ƀ��x���t������printType()�Ŏg�p�����
	public static String[]
			basic = {"class", "interface", "enum", "annotation"}, 
	        supercl = {"extends", "implements"}, 
	        iFace = {null, "extends"};
	
	public void printType(Type type, int depth, String[] labels){
		if(type == null)//�ċN�Ăяo����~�F�X�[�p�[�^�C�v�����݂��Ȃ��B
			return;
		
		//Type���N���X�I�u�W�F�N�g�ɕϊ�����
		Class<?> cls = null;
		if(type instanceof Class<?>)
			cls = (Class<?>)type;
		else if(type instanceof ParameterizedType)
			cls = (Class<?>)((ParameterizedType)type).getRawType();
		else
			throw new Error("Unexpected non-class type");
		
		if(cls.isMemberClass()){
			out.print(cls.getDeclaringClass());
		}
		for(int i = 0; i < depth; i++)
			out.println(" ");
			int kind = cls.isAnnotation() ? 3 : 
				cls.isEnum() ? 2 :
				cls.isInterface() ? 1 : 0;
			if(cls.getCanonicalName() != "java.lang.Object"){
				out.print(labels[kind] + " ");
				out.print(cls.getCanonicalName());
			}
			
			//����΁A�W�F�l���b�N�^�p�����[�^��\��
			TypeVariable<?>[] params = cls.getTypeParameters();
			if(params.length > 0){
				out.print('<');
				for(int i = 0; i < params.length; i++){
					out.print(params[i].getName());
					if(i != params.length - 1){
						out.print(", ");
					}
				}
				out.print(">");
			}
			else 
				out.print("");
			
			//���̃N���X���������Ă���S�ẴC���^�[�t�F�[�X��\��
			Type[] interfaces = cls.getGenericInterfaces();
			for(Type iface : interfaces){
				printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
			}
			
			//�X�[�p�[�N���X�ɑ΂��čċA
			printType(cls.getGenericSuperclass(), depth + 1, supercl);
			
			list.add(cls);
	}
	
	public static void main(String[] args) {
		//Please input the value of "String[] args" from the settings of Java application.
		TypeDesc desc = new TypeDesc();
		for(String name : args){
			try {
				Class<?> startClass = Class.forName(name);
				desc.printType(startClass, 0, basic);
			} catch (ClassNotFoundException e) {
				System.err.println(e);//report the error
			}
		}
	}

}
