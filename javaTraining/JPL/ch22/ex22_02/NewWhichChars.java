package ch22.ex22_02;

import java.util.BitSet;
import java.util.HashSet;

public class NewWhichChars {
	private HashSet<Character> used = new HashSet<Character>();
	
	public NewWhichChars(String str){
		for(int i = 0; i < str.length(); i++){
			used.add(Character.valueOf(str.charAt(i)));
		}
	}
	
	/**
	 * Create string containing all characters you used. The order of characters is not 
	 * always the same as contained.
	 */
	public String toString(){
		String desc = "[";
		for(Character c : used){
			desc += c;
			System.out.println("hashCode of " + c + ":" + c.hashCode());
		}
		return desc + "]";
	}
	
	public static void main(String[] args) {
		NewWhichChars wc = new NewWhichChars("Testing 1 2 3");
		System.out.println("All characters you used: " + wc.toString());
	}

}
