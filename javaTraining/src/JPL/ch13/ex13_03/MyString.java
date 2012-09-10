package JPL.ch13.ex13_03;

public class MyString {
		
	public static String delimitedString(String from, char start, char end){
		int startPos = from.indexOf(start);
		int endPos = from.indexOf(end);
		if(startPos == -1){
			return null;
		}
		else if(endPos == -1){
			return from.substring(startPos);
		}
		else
			return from.substring(startPos, endPos+1);
	}
	
	public static String[] delimitedStringArray(String from, char start, char end){
		//���ʂ��i�[����z��̐����B�e�ʂ͊܂܂��start�̐���葽���͂Ȃ�Ȃ��B
		final int maxOfResultSize = countIncludedChar(from, start);
		String[] temporaryResult = new String[maxOfResultSize];
		
		int resultSize = 0;
		
		int index = 0;
		String testedString = from;
		int endPos = 0;
		
		while(index < temporaryResult.length){
			String str = delimitedString(testedString, start, end);
			endPos = testedString.indexOf(end);
			if(str != null){
				temporaryResult[index] = str;	
				testedString = testedString.substring(endPos+1);//���̕����񂩂�start,end�ň͂܂ꂽ������������Ď��񌟍����镶����𐶐��B
				resultSize++;
			}
			else
				break;
			index++;
		}
		
		//���g������v�f�����i�[
		String[] result = new String[resultSize];
		for(int i = 0; i < result.length; i++){
			result[i] = temporaryResult[i];
		}
		return result;
	}
	
	public static int countIncludedChar(CharSequence charseq, char searchedChar){
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
	
	
	public static int countIncludedString(CharSequence charseq, String str){
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
		String[] strs = delimitedStringArray("<aa><bb><Hello>", '<', '>');
		for(int i = 0; i < strs.length; i++){
			System.out.println("array"+i+":"+strs[i]);
		}
	}

}
