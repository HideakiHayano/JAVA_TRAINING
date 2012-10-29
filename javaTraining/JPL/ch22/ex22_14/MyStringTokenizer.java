package ch22.ex22_14;

import java.util.StringTokenizer;

public class MyStringTokenizer {
	/**
	 * Extract double numbers from the string and calculate the total.
	 * @param str
	 * @return
	 */
	public double total(String str){
		StringTokenizer tokens = new StringTokenizer(str, " ");
		double total = 0;
		while(tokens.hasMoreTokens()){
			try{
				total += Double.parseDouble(tokens.nextToken());
			}
			catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}
		return total;
	}

	public static void main(String[] args) {
		String str = "0.22 0.56 0.33 0.44";
		MyStringTokenizer st = new MyStringTokenizer();
		System.out.println(st.total(str));
	}

}
