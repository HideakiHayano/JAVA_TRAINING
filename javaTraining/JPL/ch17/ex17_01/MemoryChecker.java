package ch17.ex17_01;

public class MemoryChecker {
	
	static Runtime rt = Runtime.getRuntime();
	
	public static void memoryCheck(){
		System.out.println("Free memory is " + rt.freeMemory() + " [byte].");
	}
	
	public static void gc(){
		rt.gc();
	}
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 100000000; i++){
			Object obj = new Object();
		}
		
		System.out.println("before gc");
		memoryCheck();
		gc();
		System.out.println("after gc");
		memoryCheck();
		
		
	}

}
