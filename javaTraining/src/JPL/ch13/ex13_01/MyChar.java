package JPL.ch13.ex13_01;

public class MyChar {
		
	public int countIncludedChar(CharSequence charseq, char searchedChar){
		if(charseq == null){
			System.out.println("�L��Ȓl���͂��Ă�������");
		}
		
		String testedStr = charseq.toString();
		int count = 0;
		
		for(int i=0; i<testedStr.length(); i++){
			if(testedStr.charAt(i) == searchedChar){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {

		MyChar myString = new MyChar();
		System.out.println(myString.countIncludedChar("abababaaa", 'a'));

	}

}
