package JPL.ch7.ex7_3;

public class PascalTriangle {
	
	private int [][]pascalsTriangle;
	private int size;
	
	public PascalTriangle(int size){
		this.size = size;
		pascalsTriangle = new int[size+1][size+1];
		
		for(int i=1; i<=size; i++){
			for(int j=1; j<=i; j++){
				pascalsTriangle[i][j] = combination(i-1, j-1);
			}
		}
	}
	
	public void show(){
		for(int i=1; i<=size; i++){
			for(int j=1; j<=i; j++){
				System.out.print(pascalsTriangle[i][j]);
				if(j!=i){
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}
	
	private int combination(int n, int r){
			return factorial(n)/(factorial(r)*factorial(n-r));
	}
	
	private int factorial(int n){
		int save = 1;
		if(n!=0){
			for(int i=n; i>0; i--){
				save *= i;		
			}
		}
		return save;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle p = new PascalTriangle(12);
		p.show();
	}

}
