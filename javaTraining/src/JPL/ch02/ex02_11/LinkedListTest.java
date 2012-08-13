package JPL.ch2.ex2_11;

import static org.junit.Assert.*;

import org.junit.Test;

import JPL.ch2.ex2_11.LinkedList;
import JPL.ch2.ex2_10.Vehicle;

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
