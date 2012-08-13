package JPL.ch2.ex2_5;

public class Vehicle {

	/**
	 * @param args
	 */
	
	public double speed;
	public double angle;
	public String ownerName;
	public int id;
	
	public static int nextID;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle bike = new Vehicle();
		bike.speed = 20;
		bike.angle = 0;
		bike.ownerName = "Roger";
		bike.id = 1;
		
		System.out.println("bikeのスピード：:" + bike.speed);
		System.out.println("bikeの角度：:" + bike.angle);
		System.out.println("bikeのID:" + bike.id);
		
		Vehicle car = new Vehicle();
		car.speed = 60;
		car.angle = 0;
		car.ownerName = "Rafael";
		car.id = 2;
		
		System.out.println("carのスピード：:" + car.speed);
		System.out.println("carの角度：:" + car.angle);
		System.out.println("carのID:" + car.id);
		
		Vehicle train = new Vehicle();
		train.speed = 80;
		train.angle = 0;
		train.ownerName = "Rafael";
		train.id = 3;
		
		System.out.println("trainのスピード：:" + train.speed);
		System.out.println("trainの角度：:" + train.angle);
		System.out.println("trainのID:" + train.id);
		
	}

}
