package ch02.ex02_09;

import static org.junit.Assert.*;

import org.junit.Test;

import ch02.ex02_09.Vehicle;

public class VehicleTest {

	@Test
	public void test() {
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
		
		
		int testedID = train.id;
		assertEquals(testedID, Vehicle.getMAXID());
	}

}
