package ch02.ex02_06;

import static org.junit.Assert.*;

import org.junit.Test;

import ch02.ex02_05.Vehicle;

public class LinkedListTest {

	@Test
	public void test() {

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
			
			//test
			if(list.object[0].equals(bike) &&
			   list.object[1].equals(car) &&
			   list.object[2].equals(train)){
				System.out.println("����");
			}
			else{
				
				fail();
				
			}
			
	}

}
