package JPL.ch13.ex13_5;

public class MyStringBuilder {
	
	public static char COMMA = ',';
	
	public String insert1000Separator(String original){
//		try{
//			Integer.parseInt(original);
//		}catch(NumberFormatException e){
//			System.out.println("数字の文字列を入力してください");
//		}
		
		StringBuffer buf = new StringBuffer(original);
		buf = buf.reverse();//下位からケタを数えるため
		
		//3ケタごとに","を挿入。
		//4*iになっているのは3ケタ+","のため。
		//original.length()/3-1となっているのは最後に","を入れないため。
		for(int i = 0; i < original.length()/3-1; i++){
			buf.insert(3+4*i, COMMA);
		}
		//文字列をもとの順番に戻す
		return buf.reverse().toString();
	}
	
	public static void main(String[] args) {
		MyStringBuilder sb = new MyStringBuilder();
		String test = "111111111111";
		System.out.println(sb.insert1000Separator(test));
	}

}
