package JPL.ch3.ex3_6;

public class Battery extends EnergySource{
	private final double capacityOfBattery = 100;
	private double leftBattery = capacityOfBattery;
	
	boolean empty(){
		if(leftBattery == 0){
			return true;
		} 
		else
			return false;
	}
}
