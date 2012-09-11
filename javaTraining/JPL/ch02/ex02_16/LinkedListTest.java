package ch02.ex02_16;

import junit.framework.TestCase;

import org.junit.Test;

import ch02.ex02_15.Vehicle;
import ch02.ex02_16.LinkedList;

public class LinkedListTest extends TestCase{

	@Test
	public void test() {
		Vehicle bike = new Vehicle("Roger");
		bike.setSpeed(20);
		bike.setAngle(0);
		
		Vehicle car = new Vehicle("Rafael");
		car.setSpeed(60);
		car.setAngle(0);
			
		Vehicle train = new Vehicle("Rafael");
		train.setSpeed(80);
		train.setAngle(0);
		
		int listSize = 5;
		
		LinkedList list = new LinkedList(listSize);
		list.addContent(bike);
		list.addContent(car);
		list.addContent(train);	
		
		//���X�g�̗v�f����3
		assertEquals(3, list.getNumOfContents());
	}
	
}
