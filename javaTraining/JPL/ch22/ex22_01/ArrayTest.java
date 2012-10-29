package ch22.ex22_01;

public class ArrayTest {
	/**
	 * Show float numbers contained in an array with precision of designated digits .
	 * @param array
	 * @param digit
	 */
	public static void show(double[] array, int digit){
		for(int i = 0; i < array.length; i++){
			StringBuffer buf = new StringBuffer();
			buf.append("%.");
			buf.append(Integer.valueOf(digit) + "g");
			buf.append(" %n");
			System.out.printf(buf.toString(), array[i]);
		}
	}
	
	public static void main(String[] args) {
		double[] array = {4.5, 3344, 44.555, 100, 5555.5555555};
		ArrayTest.show(array, 3);
	}

}
