package JPL.ch3.ex3_8;

import junit.framework.TestCase;

import org.junit.Test;

public class PassengerVehicleTest extends TestCase{

	@Test
	public void testClone() {
		PassengerVehicle p = new PassengerVehicle();
		PassengerVehicle test = p.clone();
		
		assertEquals(true, p.angle == test.angle);
		assertEquals(true, p.speed == test.speed);
		assertEquals(true, p.ownerName == test.ownerName);
		assertEquals(true, p.id == test.id);
	}

}
