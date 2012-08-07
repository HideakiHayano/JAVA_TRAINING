package Interpret;


import java.awt.Color;
import java.lang.reflect.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Interpret.MyFrame.ClosingWindowListener;

public class Interpret{
	
	static MyFrame.Display display;
	static MyFrame.Display display1;
	static MyFrame.Display display2;
	
	Interpret(MyFrame.Display display, MyFrame.Display display1, MyFrame.Display display2){
		this.display = display;
		this.display1 = display1;
		this.display2 = display2;
	}
	
	static String message = new String();
	/**
	 * クラスのオブジェクトを取得する
	 * 
	 * @param String name クラスの名前
	 */
	public static Class<?> getClass(String name){
		StringBuffer tempMessage = new StringBuffer(); 
		Class<?> cls = null;
		try {
			cls = Class.forName(name);
			tempMessage.append("以下のクラスオブジェクトを取得: " + name + "\r\n");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			tempMessage.append("ClassNotFoundException\r\n");
		}
		message = tempMessage.toString();
		display.append(message);
		return cls;
	}
	
	/**
	 * 指定されたクラスのインスタンスを生成する
	 * 
	 * @param Class<?> cls インスタンスを生成したいクラス
	 */
	public static Object getInstance(Class<?> cls) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, SecurityException, NoSuchMethodException{
		message = "以下のクラスのインスタンスを生成:" + cls.getName() + "\r\n";
		display.append(message);
		return cls.newInstance();
	}
	
	/**
	 * 指定されたクラスのインスタンスを生成する
	 * 
	 * @param Class<?> cls インスタンスを生成したいクラス
	 * @param Object... args インスタンス生成に用いるパラメータ
	 */
	public static Object getInstance(Class<?> cls, Object... args) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, SecurityException, NoSuchMethodException{
		message = "以下のクラスのインスタンスを生成:" + cls.getName() + "\r\n";
		display.append(message);
		if(args == null){
			return cls.newInstance();
		}
		else{
			Class<?>[] argsArray = new Class<?>[args.length];
			for(int i = 0; i < args.length; i++){
				argsArray[i] = getClassObject(args[i]);
			}
			Constructor<?> con = cls.getDeclaredConstructor(argsArray);
			return con.newInstance(args);
		}
	}
	
	/**
	 * ユーザが指定した型とサイズで配列を生成する
	 * 
	 * @param Class<T> type 配列の要素の型
	 * @param int size 配列のサイズ
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(Class<T> type, int size){
		message = "以下の配列を生成。要素型　" + type.getName() + " " + "サイズ: " + size + "\r\n";
		display.append(message);
		return  (T[]) Array.newInstance(type, size);
	}
	
	public static void setElement(Object[] oArr, Object value, int index){
		StringBuffer tempMessage = new StringBuffer();
		tempMessage.append("配列に値を代入。 インデックス: " + index + " " + "要素型: " + value.getClass().getName() + "\r\n");
		int size = oArr.length;
		if(index >= 0 && index < size){
			oArr[index] = (Object)value;
		}
		else{
			tempMessage.append("インデックスが不正です\r\n");
		}
		message = tempMessage.toString();
		display.append(message);
	}
	
	public static Object getElement(Object[] oArr, int index){
		return oArr[index];
	}
	
	/**
	 * オブジェクトのフィールドに値を設定する
	 * 
	 * @param Object o フィールドに値を設定したいオブジェクト
	 * @param String fieldName 値を設定したいフィールドの名前
	 * @param Object value フィールドに設定したい値
	 */
	public static void setField(Object o, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		Field field;
		try{
			field = o.getClass().getField(fieldName);
		}catch(NoSuchFieldException e){
			try{
				field = o.getClass().getDeclaredField(fieldName);
			}
			catch(NoSuchFieldException e1){
				field = o.getClass().getSuperclass().getField(fieldName);
			}
		}
		if(field.isAccessible() == false){
			//privateメンバにもアクセス可能になる
			field.setAccessible(true);
		}
		field.set(o, value);
		message = "オブジェクト"+ o + "のフィールド"+ fieldName + "に値"+ value + "をセット\r\n";
		display.append(message);
	}
	
	public static Object getField(Object o, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		Field field;
		try{
			field = o.getClass().getField(fieldName);
		}catch(NoSuchFieldException e){
			try{
				field = o.getClass().getDeclaredField(fieldName);
			}
			catch(NoSuchFieldException e1){
				field = o.getClass().getSuperclass().getField(fieldName);
			}
		}

		if(field.isAccessible() == false){
			//privateメンバにもアクセス可能になる
			field.setAccessible(true);
		}
		Object value = field.get(o);
		message = "オブジェクト"+ o + "のフィールド"+ fieldName + ": "+ value + "\r\n";
		display.append(message);
		return value;
	}
	
	/**
	 * オブジェクトのメソッドを呼び出す
	 * 
	 * @param Object o メソッドを呼び出したいオブジェクト
	 * @param String methodName 呼び出したいメソッドの名前
	 * @param Object... args メソッドのパラメータ
	 * @throws NoSuchMethodException 
	 * 
	 */
	public static Object invoke(Object o, String methodName, Object... args) throws SecurityException, ClassNotFoundException, NoSuchMethodException{
		StringBuffer tempMessage = new StringBuffer();
		Method method = null;
		if(args == null){
			try {
				method = o.getClass().getMethod(methodName, null);
			} catch (NoSuchMethodException e) {
				try {
					method = o.getClass().getSuperclass().getMethod(methodName, null);
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
					try{
						method = o.getClass().getDeclaredMethod(methodName, null);
					}catch(NoSuchMethodException e2){
						try{
							method = o.getClass().getSuperclass().getDeclaredMethod(methodName, null);
						}catch(NoSuchMethodException e3){
							e3.printStackTrace();
							message = "NoSuchMethodException\r\n";
							display.append(message);
						}
					}
				}
			}
		}
		else{
			//argsArray:メソッドの引数の型配列
			Class<?>[] argsArray = new Class<?>[args.length];
			for(int i = 0; i < args.length; i++){
				argsArray[i] = getClassObject(args[i]);
				//スーパークラスを引数にとれるように修正
//				argsArray[i] = getClassObject(args[i]).getSuperclass();
			}
			try {
				method = o.getClass().getMethod(methodName, argsArray);
			} catch (NoSuchMethodException e) {
				try {
					method = o.getClass().getSuperclass().getMethod(methodName, argsArray);
				} catch (NoSuchMethodException e1) {
					try{
						method = o.getClass().getDeclaredMethod(methodName, argsArray);
					}catch (NoSuchMethodException e2) {
						try{
							method = o.getClass().getSuperclass().getDeclaredMethod(methodName, argsArray);
						}
						catch(NoSuchMethodException e3){
							e3.printStackTrace();
							message = "NoSuchMethodException\r\n";
							display.append(message);
						}
					}
				}
			}
		}
		
		tempMessage.append("method: " + method.getName() + " is called.\r\n");
		
		if(Modifier.isPrivate(method.getModifiers())){
			method.setAccessible(true);
		}
		if(o.equals(null)){
			if(Modifier.isStatic(method.getModifiers()) == false){
				throw new NoSuchMethodException();
			}
		}
		
		try {
			Type returnType = method.getGenericReturnType();
			tempMessage.append("return type: " + returnType.toString() + "\r\n");
			if(returnType.equals(Void.TYPE)){
				tempMessage.append("return value: " + "なし\r\n");
			}else{
				tempMessage.append("return value: " + method.invoke(o, args).toString() + "\r\n");
			}
			message = tempMessage.toString();
			display.append(message);
			return method.invoke(o, args);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			message = tempMessage.append("IllegalArgumentException\r\n").toString();
			display.append(message);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			message = tempMessage.append("IllegalAccessException\r\n").toString();
			display.append(message);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			tempMessage.append("InvocationTargetException\r\n");
			message = tempMessage.append(e.getCause().toString() + "\r\n").toString();
			display.append(message);
		}
		return null;
	}
	
	/**
	 * オブジェクトのメソッドを呼び出す
	 * 
	 * @param Object o メソッドを呼び出したいオブジェクト
	 * @param String methodName 呼び出したいメソッドの名前
	 * @param String... args ユーザが文字列で指定するメソッドのパラメータ
	 * @throws NoSuchMethodException 
	 * 
	 */
	public static Object invoke(Object o, String methodName, String... args) throws SecurityException, ClassNotFoundException, NoSuchMethodException{
		StringBuffer tempMessage = new StringBuffer();
		Method method = null;
		Object[] realArgs = null;
		Class<?>[] argsArray = null;
		Type[] parameterType = new Type[args.length];
		
		if(args == null){
			try {
				method = o.getClass().getDeclaredMethod(methodName, null);
			} catch (NoSuchMethodException e) {
				try {
					method = o.getClass().getSuperclass().getDeclaredMethod(methodName, null);
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
					message = "NoSuchMethodException\r\n";
					display.append(message);
				}
			}
		}
		else{
			//argsArray:メソッドの引数の型配列
			argsArray = new Class<?>[args.length];
			for(int i = 0; i < args.length; i++){
				argsArray[i] = getClassObject(args[i]);
			}
			try {
				method = o.getClass().getDeclaredMethod(methodName, argsArray);
				tempMessage.append("以下のクラスからメソッドを取得: "+ o.getClass().toString() + "\r\n");
			} catch (NoSuchMethodException e) {
				try {
					tempMessage.append("以下のクラスからメソッドを取得: "+ o.getClass().getSuperclass().toString() + "\r\n");
					method = o.getClass().getSuperclass().getDeclaredMethod(methodName, argsArray);
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
					message = tempMessage.toString() + "NoSuchMethodException\r\n";
					display.append(message);
				}
			}
		}
		tempMessage.append("method: " + method.getName() + " is called.\r\n");
		
		if(Modifier.isPrivate(method.getModifiers())){
			method.setAccessible(true);
		}
		if(o.equals(null)){
			if(Modifier.isStatic(method.getModifiers()) == false){
				throw new NoSuchMethodException();
			}
		}
		
		try {
			parameterType = method.getGenericParameterTypes();
			//ユーザ指定のStringパラメータを呼びたいメソッドの引数の型に変換してObject型配列に格納
			realArgs = stringToObject(args, parameterType);
			
			Type returnType = method.getGenericReturnType();
			tempMessage.append("return type: " + returnType.toString() + "\r\n");
			
			if(returnType.equals(Void.TYPE)){
				tempMessage.append("return value: " + "なし\r\n");
			}else{
				tempMessage.append("return value: " + method.invoke(o, realArgs).toString() + "\r\n");
			}
			
			message = tempMessage.toString();
			display.append(message);
			return method.invoke(o, realArgs);
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			message = tempMessage.toString() + "IllegalArgumentException\r\n";
			display.append(message);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			message = tempMessage.toString() + "IllegalAccessException\r\n";
			display.append(message);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			tempMessage.append("InvocationTargetException\r\n");
			message = tempMessage.toString() + e.getCause().toString() + "\r\n";
			display.append(message);
		}
		return null;
	}
	
	private static Class<?> getClassObject(Object o) throws ClassNotFoundException{
		//基本データ型の場合
		if(o instanceof Boolean){
			return boolean.class;
		}
		else if(o instanceof Integer){
			return int.class;
		}
		else if(o instanceof Double){
			return double.class;
		}
		else if(o instanceof Long){
			return long.class;
		}
		else if(o instanceof Short){
			return short.class;
		}
		else if(o instanceof Character){
			return char.class;
		}
		else if(o instanceof Byte){
			return byte.class;
		}
		else if(o instanceof Float){
			return float.class;
		}
		//基本データ型以外の場合:forName()でクラスオブジェクトを取得
		else{
			return Class.forName(strip(o.getClass().toString(), "class "));
		}
		
	}
	
	public static Object[] stringToObject(String[] str, Type[] type){
		
		Object[] oArr = new Object[str.length];
		
		for(int i = 0; i < oArr.length; i++){
			//基本データ型の場合
			System.out.println("type: "+type[i].toString());
			if(type[i].equals(String.class)||type[i].equals(String.class.getSuperclass())){
				oArr[i] = str[i];
			}
			else if(type[i].equals(Boolean.TYPE)){
				oArr[i] = Boolean.parseBoolean(str[i]);
			}
			else if(type[i].equals(Integer.TYPE)){
				oArr[i] = Integer.parseInt(str[i]);
			}
			else if(type[i].equals(Double.TYPE)){
				oArr[i] = Double.parseDouble(str[i]);
			}
			else if(type[i].equals(Long.TYPE)){
				oArr[i] = Long.parseLong(str[i]);
			}
			else if(type[i].equals(Short.TYPE)){
				oArr[i] = Short.parseShort(str[i]);
			}
			else if(type[i].equals(Character.TYPE)){
				oArr[i] = str[i].charAt(0);
			}
			else if(type[i].equals(Byte.TYPE)){
				oArr[i] = Byte.parseByte(str[i]);
			}
			else if(type[i].equals(Float.TYPE)){
				oArr[i] = Float.parseFloat(str[i]);
			}
			//基本データ型以外の場合:forName()でクラスオブジェクトを取得
			else{
//				return Class.forName(strip(o.getClass().toString(), "class "));
				System.out.println("基本データ型");
			}
		}
		return oArr;
	}
	
	/**
	 * すべてのメンバを表示する
	 * 
	 * @param Class<?> c メンバを表示したいクラス型オブジェクト
	 */
	public static void printAllMembers(Class<?> c){
		System.out.println("クラス: ");
		System.out.println(c);
		
		System.out.println("フィールド: ");
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
		
		System.out.println("コンストラクタ: ");
		Constructor[] declaredconstructors = c.getDeclaredConstructors();
		Constructor[] constructors = c.getConstructors();
		ArrayList<Constructor> constructorList = new ArrayList<Constructor>(constructors.length); 
		for(int i = 0; i < constructors.length; i++){
			constructorList.add(constructors[i]);
		}
		for(int i = 0; i < declaredconstructors.length; i++){
			if(!constructorList.contains(declaredconstructors[i])){
				constructorList.add(declaredconstructors[i]);
			}
		}
		Constructor[] allConstructors = new Constructor[constructorList.size()];
		for(int i = 0; i < allConstructors.length; i++){
			allConstructors[i] = constructorList.get(i);
		}
		printMembers(allConstructors);
		
		System.out.println("メソッド: ");
		Method[] declaredmethods = c.getDeclaredMethods();
		Method[] methods = c.getMethods();
		ArrayList<Method> methodList = new ArrayList<Method>(methods.length); 
		for(int i = 0; i < methods.length; i++){
			methodList.add(methods[i]);
		}
		for(int i = 0; i < declaredmethods.length; i++){
			if(!methodList.contains(declaredmethods[i])){
				methodList.add(declaredmethods[i]);
			}
		}
		Method[] allMethods = new Method[methodList.size()];
		for(int i = 0; i < allMethods.length; i++){
			allMethods[i] = methodList.get(i);
		}
		printMembers(allMethods);
	}
	
	public static void printFields(Class<?> c){
		System.out.println("フィールド: ");
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
	
	public static void printConstructors(Class<?> c){
		System.out.println("コンストラクタ: ");
		Constructor[] declaredconstructors = c.getDeclaredConstructors();
		Constructor[] constructors = c.getConstructors();
		ArrayList<Constructor> constructorList = new ArrayList<Constructor>(constructors.length); 
		for(int i = 0; i < constructors.length; i++){
			constructorList.add(constructors[i]);
		}
		for(int i = 0; i < declaredconstructors.length; i++){
			if(!constructorList.contains(declaredconstructors[i])){
				constructorList.add(declaredconstructors[i]);
			}
		}
		Constructor[] allConstructors = new Constructor[constructorList.size()];
		for(int i = 0; i < allConstructors.length; i++){
			allConstructors[i] = constructorList.get(i);
		}
		printMembers(allConstructors);
	}
	
	public static void printMethods(Class<?> c){
		System.out.println("メソッド: ");
		Method[] declaredmethods = c.getDeclaredMethods();
		Method[] methods = c.getMethods();
		ArrayList<Method> methodList = new ArrayList<Method>(methods.length); 
		for(int i = 0; i < methods.length; i++){
			methodList.add(methods[i]);
		}
		for(int i = 0; i < declaredmethods.length; i++){
			if(!methodList.contains(declaredmethods[i])){
				methodList.add(declaredmethods[i]);
			}
		}
		Method[] allMethods = new Method[methodList.size()];
		for(int i = 0; i < allMethods.length; i++){
			allMethods[i] = methodList.get(i);
		}
		printMembers(allMethods);
	}
	
	/**
	 * すべてのメンバを表示する
	 * 
	 * @param Class<?> c メンバを表示したいクラス型オブジェクト
	 * @param String stripped 表示を省略したい文字列
	 */
	public static void printAllMembers(Class<?> c, String stripped){
		System.out.println(c);
		printMembers(c.getDeclaredFields(), stripped);
		printMembers(c.getDeclaredConstructors(), stripped);
		printMembers(c.getDeclaredMethods(), stripped);
	}
	/**
	 * 指定されたメンバを表示する
	 * 
	 * @param Member[] mems 表示したいメンバ型オブジェクト
	 */
	public static void printMembers(Member[] mems){
		for(Member m : mems){
			if(m.getDeclaringClass() == Object.class){
				continue;
			}
			String decl = m.toString() + "\r\n";
			display2.append(decl);
		}
	}
	/**
	 * 指定されたメンバを表示する
	 * 
	 * @param Member[] mems 表示したいメンバ型オブジェクト
	 * @param String stripped 表示を省略したい文字列
	 */
	public static void printMembers(Member[] mems, String stripped){
		for(Member m : mems){
			if(m.getDeclaringClass() == Object.class){
				continue;
			}
			String decl = m.toString() + "\r\n";
			display2.append(strip(decl, stripped));
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
	
	public static void main(String[] args) throws Exception{
//		Class<? extends java.awt.Frame> cls = getClass("java.awt.Frame").asSubclass(Frame.class);
		Class cls = getClass("java.awt.Frame");
//		printAllMembers(cls);
//		Frame[] frameArr = toArray(cls, 2);
		System.out.println();
//		Frame frame = (Frame) getInstance(cls, "Rafa");
		Object frame = getInstance(cls);
//		setElement(frameArr, frame, 0);
//		invoke(frameArr[0], "getTitle");
//		setField(frameArr[0], "title", "tennis365");
//    	invoke(frameArr[0], "setResizable", true);
//    	invoke(frameArr[0], "setTitle", "tennis846");
//    	invoke(frameArr[0], "setSize", 200, 100);
//    	invoke(frameArr[0], "setBackground", Color.GREEN);
//    	invoke(frameArr[0], "setVisible", true);
//    	invoke(frameArr[0], "getTitle");
//    	invoke(frameArr[0], "getSize");
		
		String[] str = new String[2];
		str[0] = "true";
		str[1] = "bbb";
		
		Object[] oList = toArray(Object.class, 100);
		oList[0] = getInstance(cls, "rafa");
		ArrayList arr = new ArrayList();
		arr.add(oList[0]);
		System.out.println("0."+arr.get(0).getClass().getSuperclass().toString());
		System.out.println("1."+cls.getSuperclass().toString());
		System.out.println("2."+oList[0].getClass().getSuperclass().toString());
		printAllMembers(oList[0].getClass());
		
		invoke(oList[0], "getTitle");
//		invoke(oList[0],  "setField", "title", "tennis365");
//		invoke(oList[0], "getField", "title");
		setField(oList[0], "title", "tennis365");
		System.out.println("field: " + getField(oList[0], "title"));
    	invoke(oList[0], "setResizable", true);
    	invoke(oList[0], "setTitle", "tennis846");
    	invoke(oList[0], "setSize", 200, 100);
    	invoke(oList[0], "setBackground", Color.GREEN);
//    	invoke(oList[0], "setVisible", true);
    	invoke(oList[0], "getTitle");
    	invoke(oList[0], "getSize");
		
//		invoke(frame, "getTitle");
//		setField(frame, "title", "tennis365");
//    	invoke(frame, "setResizable", true);
//    	invoke(frame, "setTitle", "tennis846");
//    	invoke(frame, "setSize", 200, 100);
//    	invoke(frame, "setBackground", Color.GREEN);
////    	invoke(frame, "setVisible", true);
//    	invoke(frame, "getTitle");
//    	invoke(frame, "getSize");

	}

}
