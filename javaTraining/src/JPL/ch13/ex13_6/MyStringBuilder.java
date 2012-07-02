package JPL.ch13.ex13_6;

public class MyStringBuilder {
	
	public String insert1000Separator(String original, char separator, int per){
		
		StringBuffer buf = new StringBuffer(original);
		buf = buf.reverse();//下位からケタを数えるため
		
		//perケタごとに","を挿入。
		//(per+1)*iになっているのはperケタ+","のため。
		//original.length()/per-1となっているのは最後にseparatorを入れないため。
		for(int i = 0; i < original.length()/per-1; i++){
			buf.insert(per+(per+1)*i, separator);
		}
		//文字列をもとの順番に戻す
		return buf.reverse().toString();
	}
	
	public static void main(String[] args) {
		MyStringBuilder sb = new MyStringBuilder();
		String test = "111111111111";
		System.out.println(sb.insert1000Separator(test, '/', 4));
	}

}
