package JPL.ch2.ex2_10;

import static org.junit.Assert.*;

import org.junit.Test;

import JPL.ch2.ex2_10.Vehicle;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle bike = new Vehicle("Roger");
		bike.speed = 20;
		bike.angle = 0;
		
		System.out.println(bike.toString());
		
	}

}
