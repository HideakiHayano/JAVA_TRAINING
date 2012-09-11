package ch01.ex01_10;

public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����v�f��*�����āA�t�B�{�i�b�`����̍ŏ��̕�̗v�f��\������
		
		System.out.println("��ǃt�B�{�i�b�`����");
		
		int[] improvedFibonacci = new int[MAX_INDEX];
		
		ImprovedFibonacci ex = new ImprovedFibonacci(); 
		CheckEven checkEven = ex.new CheckEven(MAX_INDEX);
		
		int lo = 1;
		int hi = 1;
		
		improvedFibonacci[0] = lo;
		
		for(int i = MAX_INDEX-1; i >= 1; i--){
			
			improvedFibonacci[MAX_INDEX - i] = hi;
			
			checkEven.setBooleanValue(MAX_INDEX - i, hi);
			
			hi = lo + hi;
			lo = hi- lo;
			
		}
		
		System.out.println("��ǃt�B�{�i�b�`����̒l, �������ǂ���");
		
		for(int i=0; i<MAX_INDEX-1; i++){
			
			System.out.println(improvedFibonacci[i] + "," + checkEven.getBooleanValue(i));
		
		}
		
	}
	
	class CheckEven{
		
		boolean[] boolFibonacci;
		
		public CheckEven(int size){
			
			boolFibonacci = new boolean[size]; 
			
		}
		
		public void setBooleanValue(int index, int improvedFibonacciValue){
			
			if(improvedFibonacciValue%2 == 0){
				
				boolFibonacci[index] = true;
				
			}
			else 
				boolFibonacci[index] = false;
			
		}
		
		public boolean getBooleanValue(int index){
			
			return boolFibonacci[index];
			
		}
		
	}
	
}
