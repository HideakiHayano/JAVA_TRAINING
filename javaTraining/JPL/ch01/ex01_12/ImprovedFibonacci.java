package ch01.ex01_12;

public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����v�f��*�����āA�t�B�{�i�b�`����̍ŏ��̕�̗v�f��\������
		
		System.out.println("��ǃt�B�{�i�b�`����");
		
		String[] stringImprovedFibonacci = new String[MAX_INDEX];
		
		int lo = 1;
		int hi = 1;
		String mark;
		
		stringImprovedFibonacci[0] = "1:" + lo;
		
		for(int i = MAX_INDEX-1; i >= 1; i--){
			
			if(hi%2 == 0) 
				mark = "*";
			
			else
				mark = "";
			
			stringImprovedFibonacci[MAX_INDEX - i] = MAX_INDEX - i + ":" + hi + mark;
			hi = lo + hi;
			lo = hi- lo;
			
		}
		
		for(int i=0; i<MAX_INDEX-1; i++){
			
			System.out.println(stringImprovedFibonacci[i]);
		
		}
		
		
	}

}
