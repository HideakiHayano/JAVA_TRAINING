package ch13.ex13_05;

public class MyStringBuilder {
	
	public static char COMMA = ',';
	
	public String insert1000Separator(String original){
//		try{
//			Integer.parseInt(original);
//		}catch(NumberFormatException e){
//			System.out.println("�����̕�������͂��Ă�������");
//		}
		
		StringBuffer buf = new StringBuffer(original);
		buf = buf.reverse();//���ʂ���P�^�𐔂��邽��
		
		//3�P�^���Ƃ�","��}��B
		//4*i�ɂȂ��Ă���̂�3�P�^+","�̂��߁B
		//original.length()/3-1�ƂȂ��Ă���͍̂Ō��","����Ȃ����߁B
		for(int i = 0; i < original.length()/3-1; i++){
			buf.insert(3+4*i, COMMA);
		}
		//����������Ƃ̏��Ԃɖ߂�
		return buf.reverse().toString();
	}
	
	public static void main(String[] args) {
		MyStringBuilder sb = new MyStringBuilder();
		String test = "111111111111";
		System.out.println(sb.insert1000Separator(test));
	}

}
