package ch22.ex22_06;

import java.util.Random;

public class GaussianTest {

	public static void main(String[] args) {
		Random ran = new Random();
		double result = 0;
		int numOftimes = 1000; 
		//Result is shown from -limit to limit following the scale.
		int scale = 100;
		int limit = 10;
		int[] countPlus = new int[scale];
		int[] countMinus = new int[scale];
		
		for(int k = 0; k < numOftimes; k++){
			result = ran.nextGaussian();
			if(result < 0){
				for(int i = 0; i < scale; i++){
					if(result > (double)-(i+1)*limit/scale && result <= (double)-i*limit/scale){
						countMinus[i]++;
					}
				}
			}
			else{
				for(int j = 0; j < scale; j++){
					if(result > (double)j*limit/scale && result < (double)(j+1)*limit/scale){
						countPlus[j]++;
					}
				}
			}
		}
		System.out.printf("\n");
		for(int i = scale-1; i >= 0; i--){
			System.out.printf((double)-(i+1)*limit/scale + " to " + (double)-i*limit/scale + ": ");
			for(int j = 0; j < countMinus[i]; j++){
				System.out.printf("*");
			}
			System.out.printf("\n");
		}
		for(int i = 0; i < scale; i++){
			System.out.printf((double)i*limit/scale + " to " + (double)(i+1)*limit/scale + ": ");
			for(int j = 0; j < countPlus[i]; j++){
				System.out.printf("*");
			}
			System.out.printf("\n");
		}
	}

}
