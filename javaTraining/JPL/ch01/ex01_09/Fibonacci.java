package ch01.ex01_09;

public class Fibonacci {
	
	public static final String TITLE = "�t�B�{�i�b�`����";
	public static final int FIBONACCI_SIZE = 20;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TITLE);
		
		int[] fibonacci = new int [FIBONACCI_SIZE];
		
		int lo = 1;
		int hi = 1;
		
		fibonacci[0] = lo;

			for(int i=0; i<FIBONACCI_SIZE; i++){

				if (hi < 50){
				
					fibonacci[i] = hi;
					hi = lo + hi;
					lo = hi- lo;
				
				}
			
			}
		
		for(int i=0; i<FIBONACCI_SIZE; i++){
			
			System.out.println(fibonacci[i]);
			
		}
	}
	
}
