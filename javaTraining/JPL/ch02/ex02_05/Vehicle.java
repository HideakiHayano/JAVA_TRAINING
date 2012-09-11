package ch02.ex02_05;

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
		
		System.out.println("bike�̃X�s�[�h�F:" + bike.speed);
		System.out.println("bike�̊p�x�F:" + bike.angle);
		System.out.println("bike��ID:" + bike.id);
		
		Vehicle car = new Vehicle();
		car.speed = 60;
		car.angle = 0;
		car.ownerName = "Rafael";
		car.id = 2;
		
		System.out.println("car�̃X�s�[�h�F:" + car.speed);
		System.out.println("car�̊p�x�F:" + car.angle);
		System.out.println("car��ID:" + car.id);
		
		Vehicle train = new Vehicle();
		train.speed = 80;
		train.angle = 0;
		train.ownerName = "Rafael";
		train.id = 3;
		
		System.out.println("train�̃X�s�[�h�F:" + train.speed);
		System.out.println("train�̊p�x�F:" + train.angle);
		System.out.println("train��ID:" + train.id);
		
	}

}
