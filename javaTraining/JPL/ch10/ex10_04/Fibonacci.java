package ch10.ex10_04;

public class Fibonacci {
	
	public static final String TITLE = "�t�B�{�i�b�`����";
	public static final int FIBONACCI_SIZE = 20;
	public static final int LIMIT = 50;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TITLE);
		
		int[] fibonacci = new int [FIBONACCI_SIZE];
		
		int lo = 1;
		int hi = 1;
		
		fibonacci[0] = lo;
		
		int i = 0;
		
		while(i<FIBONACCI_SIZE){

			if (hi < LIMIT){
				
					fibonacci[i] = hi;
					hi = lo + hi;
					lo = hi- lo;
					
					System.out.println(fibonacci[i]);
					
			}
		i++;
		}
		
	}
	
}
