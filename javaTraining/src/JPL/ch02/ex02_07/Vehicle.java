package JPL.ch2.ex2_7;

public class Vehicle {
	public double speed;
	public double angle;
	public String ownerName;
	public int id;
	
	public static int nextID = 1;
	
	public Vehicle(){
		speed = 0.0;
		angle = 0.0;
		ownerName = "";
		id = nextID;
		nextID++;
	}
	
	public Vehicle(String ownerName){
		speed = 0.0;
		angle = 0.0;
		this.ownerName = ownerName;
		id = nextID;
		nextID++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle bike = new Vehicle("Roger");
		bike.speed = 20;
		bike.angle = 0;
		
		System.out.println("bikeのスピード：:" + bike.speed);
		System.out.println("bikeの角度：:" + bike.angle);
		System.out.println("bikeのID:" + bike.id);
		
		Vehicle car = new Vehicle("Rafael");
		car.speed = 60;
		car.angle = 0;
		
		System.out.println("carのスピード：:" + car.speed);
		System.out.println("carの角度：:" + car.angle);
		System.out.println("carのID:" + car.id);
		
		Vehicle train = new Vehicle("Rafael");
		train.speed = 80;
		train.angle = 0;
		
		System.out.println("trainのスピード：:" + train.speed);
		System.out.println("trainの角度：:" + train.angle);
		System.out.println("trainのID:" + train.id);
		
	}
	
}
