package JPL.ch1.ex1_6;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static final String TITLE = "フィボナッチ数列";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TITLE);
		
		int lo = 1;
		int hi = 1;
		
		System.out.println(lo);
		
		while(hi < 50){
			
			System.out.println(hi);
			hi = lo + hi;
			lo = hi- lo;
			
		}
	}

}
