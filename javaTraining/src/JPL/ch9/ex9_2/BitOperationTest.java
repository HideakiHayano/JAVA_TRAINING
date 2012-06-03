package JPL.ch9.ex9_2;

public class BitOperationTest {
	
	public void bitCount(int value){
		String binary = Integer.toBinaryString(value).toString();
		
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BitOperationTest test = new BitOperationTest();
		test.bitCount(8);
		
	}

}
