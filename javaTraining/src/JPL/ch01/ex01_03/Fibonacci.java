package JPL.ch1.ex1_3;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//値が50未満のフィボナッチ数列を出力
		
		System.out.println("フィボナッチ数列");
		
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
