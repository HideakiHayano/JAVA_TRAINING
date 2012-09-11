package ch02.ex02_06;

import ch02.ex02_05.Vehicle;

public class LinkedList {

	/**
	 * @param args
	 */
	public int numOfElements;
	public Object[] object;
	public static int id = 0;
	
	LinkedList(int numOfElements){
		this.numOfElements =numOfElements;
		object = new Object[numOfElements];
	} 
	
	public void add(Object object){
		this.object[id] = object;
		id++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle bike = new Vehicle();
		bike.speed = 20;
		bike.angle = 0;
		bike.ownerName = "Roger";
		bike.id = 1;
		
		Vehicle car = new Vehicle();
		car.speed = 60;
		car.angle = 0;
		car.ownerName = "Rafael";
		car.id = 2;
		
		Vehicle train = new Vehicle();
		train.speed = 80;
		train.angle = 0;
		train.ownerName = "Rafael";
		train.id = 3;
		
		int numOfElements = 3;
		
		LinkedList list = new LinkedList(numOfElements);
		list.add(bike);
		list.add(car);
		list.add(train);
		
		
	}

}
