package ch16.ex16_11;

public class PlayerLoader extends ClassLoader{
//	public Class<?> findClass(String name) throws ClassNotFoundException{
//		byte[] buf = byteForClass(name);
//		return defineClass(name, buf, 0, buf.length);
//	} 
	
	public Class<?> findClass(String name) throws ClassNotFoundException{
		return super.findClass(name);
	} 
	
	public Class<?> loadClass(String name){
		try {
			return super.loadClass(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	protected byte[] byteForClass(String name) throws ClassNotFoundException{
//		FileInputStream in = null;
//		try{
//			in = streamFor(name + ".class");
//			int length = in.available();//get the value of byte.
//			if(length == 0)
//				throw new ClassNotFoundException(name);
//			byte[] buf = new byte[length];
//			in.read(buf);
//			return buf;
//		}finally{
//			if(in != null)
//				in.close();
//		}
//		return null;
//	}
	//ロードするクラスは親のローダーが見つけられない別のパスに置く。p384 そうしないと2でロードする。3に達しないと、自分のクラスローダー
	//findclassは呼ばれない。
}
