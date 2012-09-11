package ch02.ex02_07;

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
		
		System.out.println("bike�̃X�s�[�h�F:" + bike.speed);
		System.out.println("bike�̊p�x�F:" + bike.angle);
		System.out.println("bike��ID:" + bike.id);
		
		Vehicle car = new Vehicle("Rafael");
		car.speed = 60;
		car.angle = 0;
		
		System.out.println("car�̃X�s�[�h�F:" + car.speed);
		System.out.println("car�̊p�x�F:" + car.angle);
		System.out.println("car��ID:" + car.id);
		
		Vehicle train = new Vehicle("Rafael");
		train.speed = 80;
		train.angle = 0;
		
		System.out.println("train�̃X�s�[�h�F:" + train.speed);
		System.out.println("train�̊p�x�F:" + train.angle);
		System.out.println("train��ID:" + train.id);
		
	}
	
}
