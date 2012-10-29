package ch22.ex22_03;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

public class WhichChars {
	private BitSet used = new BitSet();
	private HashMap<String, BitSet> map = new HashMap<String, BitSet>();
	
	public WhichChars(String str){
		for(int i = 0; i < str.length(); i++){
			String binary = Integer.toBinaryString(str.charAt(i));
			System.out.println(binary);
			System.out.println(binary.length());
			String upperByte = binary.substring(0, 7);
			System.out.println(binary.length());
			String lowerByte = binary.substring(0, 7);
			
			//UpperByte is a binary number. On the other hand, lowerByte is a decimal number.
			used.set(Integer.parseInt(lowerByte, 2));
			map.put(upperByte, used);
		}
	}
	
	public String toString(){
		String desc = "[";
		for(int i = used.nextSetBit(0); i >= 0; i = used.nextSetBit(i+1)){
			desc += (char)i;
		}
		return desc + "]";
	}
	
	public static void main(String[] args) {
		WhichChars wc = new WhichChars("Test");
		System.out.println(wc.toString());
	}

}
