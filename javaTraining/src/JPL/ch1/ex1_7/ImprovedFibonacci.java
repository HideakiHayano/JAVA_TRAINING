package JPL.ch1.ex1_7;

public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//偶数要素に*をつけて、フィボナッチ数列の最初の方の要素を表示する
		
		System.out.println("改良フィボナッチ数列");
		
		int lo = 1;
		int hi = 1;
		String mark;
		
		System.out.println("1:" + lo);
		
		for(int i = MAX_INDEX-1; i >= 1; i--){
			
			if(hi%2 == 0) 
				mark = "*";
			
			else
				mark = "";
			
			System.out.println(MAX_INDEX - i + 1 + ":" + hi + mark);
			hi = lo + hi;
			lo = hi- lo;
			
		}
		
		
	}

}
