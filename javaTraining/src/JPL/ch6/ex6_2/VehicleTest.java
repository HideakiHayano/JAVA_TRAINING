package JPL.ch6.ex6_2;

import junit.framework.TestCase;

import org.junit.Test;

public class VehicleTest extends TestCase{
	
	private Vehicle bike;
	private final double initialAngle = 0.0;;
	private final double angle = 30.0;;
	
	public VehicleTest(){
	
		bike = new Vehicle("Roger");

	}
	
	@Test
	public void test1() {
		System.out.println("test1:turn(double)");

		bike.turn(angle);
		assertEquals(angle, bike.getAngle());
		
	}
	
	public void test2() {
		System.out.println("test2:turn(double, String LEFT)");
		
		bike.turn(angle, Vehicle.Direction.TURN_LEFT);
		assertEquals(initialAngle + angle, bike.getAngle());
		
	}
	
	public void test3() {
		System.out.println("test3:turn(double, String RIGHT)");
				
		bike.turn(angle, Vehicle.Direction.TURN_RIGHT);
		assertEquals(initialAngle - angle, bike.getAngle());
		
	}

}
