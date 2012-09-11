package ch04.ex04_01;

public class GasTank implements EnergySource{
	
	private final double capacityOfGas = 100;
	private double leftGas = capacityOfGas;
	
	public boolean empty(){
		if(leftGas == 0){
			return true;
		} 
		else
			return false;
	}
	
	void useEnergy(double usage){
		leftGas = leftGas -usage;
		if(leftGas < 0){
			leftGas = 0;
		}
	} 
}
