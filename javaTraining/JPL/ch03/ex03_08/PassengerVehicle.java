package ch03.ex03_08;

public class PassengerVehicle extends Vehicle implements Cloneable{

	private final int numOfSeats;
	private int numOfPassengers = 0;
	
	///////////////////////////////////////////////////
	//ex3_8
	public PassengerVehicle clone(){
		return (PassengerVehicle)super.clone();
	}
	///////////////////////////////////////////////////
	
	public PassengerVehicle(){
		super();
		numOfSeats = 5;
	}
	
	public PassengerVehicle(int numOfSeats, String ownerName){
		super(ownerName);
		this.numOfSeats = numOfSeats;		
	}
	
	public void putInPassengers(int numOfNewPassengers){
		this.numOfPassengers += numOfNewPassengers;
		if(numOfPassengers > numOfSeats){
			numOfPassengers = numOfSeats;
		}
	}
	
	public int getNumOfSeats(){
		return numOfSeats;
	}
	
	public int getNumOfPassengers(){
		return numOfPassengers;
	}
	
	public String toString(){
		
		if(ownerName.equals("")){
			ownerName = "������s��";
		}
		
		String desc = ownerName + "��" +"Vehicle" + id + "��"
				+ angle + "�x����" + "����" + speed + "km�ő����Ă��܂��B"
				+ "��e�\\�l����" + numOfSeats + "�l�ł���A����" + numOfPassengers + "�l" + 
				"����Ă��܂��B";
		return desc;
	}
	
	public static void main(String[] args) {
		
		PassengerVehicle car = new PassengerVehicle();
		System.out.println(car.toString());
		
		PassengerVehicle bike = new PassengerVehicle(2, "Roger");
		bike.putInPassengers(2);
		bike.changeSpeed(50);
		bike.turn(20);
		System.out.println(bike.toString());
	}
	
}
