package ch03.ex03_08;

import junit.framework.TestCase;

import org.junit.Test;

public class VehicleTest extends TestCase{

	@Test
	public void testVehicle() {
		Vehicle v = new Vehicle();
		Vehicle test = v.clone();
		
		assertEquals(true, v.angle == test.angle);
		assertEquals(true, v.speed == test.speed);
		assertEquals(true, v.ownerName == test.ownerName);
		assertEquals(true, v.id == test.id);
	}

}
