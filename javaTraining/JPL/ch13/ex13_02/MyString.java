package ch13.ex13_02;

public class MyString {
		
	public int countIncludedString(CharSequence charseq, String str){
		if(charseq == null || str == null){
			System.out.println("�L��Ȓl���͂��Ă�������");
		}
		
		String testedStr = charseq.toString();
		int count = 0;
		
		while(testedStr.contains(str)){
			count++;
			int index = testedStr.indexOf(str);
			testedStr = testedStr.substring(index+1);
		}
		return count;
	}
	
	public static void main(String[] args) {

		MyString myString = new MyString();
		System.out.println(myString.countIncludedString("abcdeabcdeabcde", "abc"));
		
		String str1="ass";
		str1.regionMatches(0, "ass", 0, 10);
		System.out.println(str1.regionMatches(0, "asssss", 0, 2));

	}

}
