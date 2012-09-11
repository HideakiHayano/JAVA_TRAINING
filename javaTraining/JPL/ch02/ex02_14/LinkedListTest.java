package ch02.ex02_14;

import junit.framework.TestCase;

import org.junit.Test;

import ch02.ex02_13.Vehicle;
import ch02.ex02_14.LinkedList;

public class LinkedListTest extends TestCase{

	@Test
	public void test1() {
		//addContent(), getContent()�̃e�X�g
		
		System.out.println("test1");
		
		Vehicle bike = new Vehicle("Roger");
		bike.setSpeed(20);
		bike.setAngle(0);
		
		Vehicle car = new Vehicle("Rafael");
		car.setSpeed(60);
		car.setAngle(0);
			
		Vehicle train = new Vehicle("Rafael");
		train.setSpeed(80);
		train.setAngle(0);
		
		int listSize = 3;
		
		LinkedList list = new LinkedList(listSize);
		
		list.addContent(bike);
		list.addContent(car);
		list.addContent(train);
		
		assertEquals(bike, list.getContent(0));
		assertEquals(car, list.getContent(1));
		assertEquals(train, list.getContent(2));
	}
	
	public void test2() {
		//addContent()���s�̃e�X�g
		System.out.println("test2");
		
		Vehicle bike = new Vehicle("Roger");
		bike.setSpeed(20);
		bike.setAngle(0);
		
		Vehicle car = new Vehicle("Rafael");
		car.setSpeed(60);
		car.setAngle(0);
			
		Vehicle train = new Vehicle("Rafael");
		train.setSpeed(80);
		train.setAngle(0);
		
		int listSize = 1;
		
		LinkedList list = new LinkedList(listSize);
		
		//�e�ʂ�����Ȃ�
		list.addContent(bike);
		list.addContent(car);
		list.addContent(train);	
		
	}

}
