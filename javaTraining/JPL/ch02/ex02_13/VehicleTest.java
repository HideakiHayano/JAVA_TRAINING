package ch02.ex02_13;

import junit.framework.TestCase;

import org.junit.Test;

import ch02.ex02_13.Vehicle;

public class VehicleTest extends TestCase{

	@Test
	public void test() {
		
		double speed = 20.2;
		double angle = 0.0;
		String newOwnerName = "Jony";
		
		Vehicle bike = new Vehicle("Roger");
		bike.setSpeed(speed);
		bike.setAngle(angle);
		bike.setOwnerName(newOwnerName);
		
		assertEquals(speed, bike.getSpeed());
		assertEquals(angle, bike.getAngle());
		assertEquals(newOwnerName, bike.getOwnerName());
		
	}

}
