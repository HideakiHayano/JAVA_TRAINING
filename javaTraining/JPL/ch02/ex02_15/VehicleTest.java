package ch02.ex02_15;

import junit.framework.TestCase;

import org.junit.Test;

import ch02.ex02_15.Vehicle;

public class VehicleTest extends TestCase{

	@Test
	public void test() {
		
		double speed = 20.2;
		
		Vehicle bike = new Vehicle("Roger");
		
		//test:changeSpeed()
		bike.changeSpeed(speed);
		assertEquals(speed, bike.getSpeed());
		
		//test:stop()
		bike.stop();
		assertEquals(0.0, bike.getSpeed());
		
	}

}
