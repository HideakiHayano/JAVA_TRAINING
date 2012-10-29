package ch22.ex22_05;

import java.util.ArrayList;
import java.util.Random;

public class DiceTest {
	private int NUM_OF_EYE = 6;
	private double[] idealMap;
	private double[] realMap;
	private int numOfDice = 0;
	
	public DiceTest(int n){
		numOfDice = n;
		idealMap = new double[NUM_OF_EYE*n+1];
		realMap = new double[NUM_OF_EYE*n+1];
	}
	
	/**
	 * Make an map which shows the probability of total eyes when n dice are shaken.
	 * @param n numOfDice
	 */
	public void makeIdealMap(){
		for(int i = 1; i < idealMap.length; i++){
			//In case that n dices are shaken, the number of combinations for total m
			//is obtained by (m-1)C(n-1). Error:Cannot take account of the value of dice eye.
			idealMap[i] = calculateCombination(i-1, numOfDice-1)/(double)factorial(NUM_OF_EYE, numOfDice);
		}
	}
	
	/**
	 * Make an map which shows the result when n dice are shaken k times.
	 * @param n numOfDice
	 * @param k
	 */
	public void makeRealMap(int k){
		for(int i = 1; i < realMap.length; i++){
			realMap[i] = 0.0;
		}
		Random ran = new Random();
		for(int i = 0; i < k; i++){
			int total = 0;
			for(int j = 0; j < numOfDice; j++){
				while(true){
					int eye = ran.nextInt(NUM_OF_EYE+1);
					if(eye != 0){
						total += eye;
						break;
					}
				}
			}
			realMap[total]++;
		}
		//(result of each total eye)/ times
		for(int i = 1; i < realMap.length; i++){
			realMap[i] = realMap[i]/k;
		}
	}
	
//	/**
//	 * Calculate nCm.
//	 * @param m
//	 * @param n
//	 * @return
//	 */
//	public static int calculateCombination(int n, int m){
//		int result = 1;
//		for(int i = n; i >= n-m+1; i--){
//			result = result*i;
//		}
//		for(int i = m; i >= 1; i--){
//			result = result/i;
//		}
//		return result;
//	}
	
	public static int calculateCombination(int n, int m){
		int result = 1;
		for(int i = (n-1); i >= (n-1)-(m-1)+1; i--){
			result = result*i;
		}
		for(int i = (m-1); i >= 1; i--){
			result = result/i;
		}
		return result;
	}
	
	/**
	 * Get the result of m multiplied by itself n times.
	 * @param m
	 * @param n
	 * @return
	 */
	public static int factorial(int m, int n){
		int result = 1;
		for(int i = n; i >= 1; i--){
			result = result*m;
		}
		return result;
	}
	
	public double[] getIdealMap(){
		return idealMap;	
	}
	
	public double[] getRealMap(){
		return realMap;	
	}
	
	public void showResult(){
		for(int i = 1; i < idealMap.length; i++){
			System.out.println("total " + i + " ");
//			System.out.println(idealMap[i]);
//			System.out.printf(" ideal " + "%1$.2f", idealMap[i]);
			System.out.printf(" real " + "%1$.2f", realMap[i]);
			System.out.printf("\n");
		}
	}
	
	public static void main(String[] args) {
		//numOfDice
		DiceTest dice = new DiceTest(1);
//		dice.makeIdealMap();
		//numOfShaken
		dice.makeRealMap(1000);
		dice.showResult();
	}

}
