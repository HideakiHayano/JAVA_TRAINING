package ch04.ex04_01;

public class Battery implements EnergySource{
	private final double capacityOfBattery = 100;
	private double leftBattery = capacityOfBattery;
	
	public boolean empty(){
		if(leftBattery == 0){
			return true;
		} 
		else
			return false;
	}
}
