package JPL.ch3.ex3_6;

public class GasTank extends EnergySource{
	
	private final double capacityOfGas = 100;
	private double leftGas = capacityOfGas;
	
	boolean empty(){
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
