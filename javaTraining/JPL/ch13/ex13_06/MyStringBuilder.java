package ch13.ex13_06;

public class MyStringBuilder {
	
	public String insert1000Separator(String original, char separator, int per){
		
		StringBuffer buf = new StringBuffer(original);
		buf = buf.reverse();//���ʂ���P�^�𐔂��邽��
		
		//per�P�^���Ƃ�","��}��B
		//(per+1)*i�ɂȂ��Ă���̂�per�P�^+","�̂��߁B
		//original.length()/per-1�ƂȂ��Ă���͍̂Ō��separator����Ȃ����߁B
		for(int i = 0; i < original.length()/per-1; i++){
			buf.insert(per+(per+1)*i, separator);
		}
		//����������Ƃ̏��Ԃɖ߂�
		return buf.reverse().toString();
	}
	
	public static void main(String[] args) {
		MyStringBuilder sb = new MyStringBuilder();
		String test = "111111111111";
		System.out.println(sb.insert1000Separator(test, '/', 4));
	}

}
