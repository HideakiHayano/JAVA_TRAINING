package ch02.ex02_11;

import static org.junit.Assert.*;

import org.junit.Test;

import ch02.ex02_11.LinkedList;
import ch02.ex02_10.Vehicle;

public class LinkedListTest {

	@Test
	public void test() {
		
		Vehicle bike = new Vehicle("Roger");
		bike.speed = 20;
		bike.angle = 0;
		
		Vehicle car = new Vehicle("Rafael");
		car.speed = 60;
		car.angle = 0;
			
		Vehicle train = new Vehicle("Rafael");
		train.speed = 80;
		train.angle = 0;
		
		int numOfElements = 3;
		
		LinkedList list = new LinkedList(numOfElements);
		list.add(bike);
		list.add(car);
		list.add(train);
		
		System.out.println(list.toString());
	}

}
