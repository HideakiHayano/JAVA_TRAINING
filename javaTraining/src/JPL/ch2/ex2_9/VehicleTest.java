package JPL.ch2.ex2_9;

import static org.junit.Assert.*;

import org.junit.Test;

import JPL.ch2.ex2_9.Vehicle;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle bike = new Vehicle("Roger");
		bike.speed = 20;
		bike.angle = 0;
		
		System.out.println("bikeのスピード：:" + bike.speed);
		System.out.println("bikeの角度：:" + bike.angle);
		System.out.println("bikeのID:" + bike.id);
		
		Vehicle car = new Vehicle("Rafael");
		car.speed = 60;
		car.angle = 0;
		
		System.out.println("carのスピード：:" + car.speed);
		System.out.println("carの角度：:" + car.angle);
		System.out.println("carのID:" + car.id);
		
		Vehicle train = new Vehicle("Rafael");
		train.speed = 80;
		train.angle = 0;
		
		System.out.println("trainのスピード：:" + train.speed);
		System.out.println("trainの角度：:" + train.angle);
		System.out.println("trainのID:" + train.id);
		
		
		int testedID = train.id;
		assertEquals(testedID, Vehicle.getMAXID());
	}

}
