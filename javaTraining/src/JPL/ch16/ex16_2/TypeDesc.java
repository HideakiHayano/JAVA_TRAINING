package JPL.ch16.ex16_2;

import java.lang.reflect.*;
import java.util.ArrayList;

import JPL.ch6.ex6_5.ColorOfTrafficLight;

public class TypeDesc {
	private ArrayList list = new ArrayList();
	
	public ArrayList getClassList(){
		return (ArrayList) list.clone();
	}
	
	//標準出力
	private java.io.PrintStream out = System.out;
	
	//型名にラベル付けするprintType()で使用される
	public static String[]
			basic = {"class", "interface", "enum", "annotation"}, 
	        supercl = {"extends", "implements"}, 
	        iFace = {null, "extends"};
	
	public void printType(Type type, int depth, String[] labels){
		if(type == null)//再起呼び出し停止：スーパータイプが存在しない。
			return;
		
		//Typeをクラスオブジェクトに変換する
		Class<?> cls = null;
		if(type instanceof Class<?>)
			cls = (Class<?>)type;
		else if(type instanceof ParameterizedType)
			cls = (Class<?>)((ParameterizedType)type).getRawType();
		else
			throw new Error("Unexpected non-class type");
		
		if(cls.isMemberClass()){
			out.println("このクラスは以下のクラスまたはインターフェースにネストしています。");
			out.print(cls.getDeclaringClass());
		}
		else{
			out.println("このクラスはネストしていません");
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
			
			//あれば、ジェネリック型パラメータを表示
			TypeVariable<?>[] params = cls.getTypeParameters();
			if(params.length > 0){
				out.print('<');
				for(int i = 0; i < params.length; i++){
					out.print(params[i].getName());
					if(i != params.length - 1){
						out.print(", ");
					}
				}
				out.println(">");
			}
			else 
				out.print("");
			
			//このクラスが実装している全てのインターフェースを表示
			Type[] interfaces = cls.getGenericInterfaces();
			for(Type iface : interfaces){
				printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
			}
			
			//スーパークラスに対して再帰
			printType(cls.getGenericSuperclass(), depth + 1, supercl);
			
			list.add(cls);
	}
	
	public static void main(String[] args) {
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
