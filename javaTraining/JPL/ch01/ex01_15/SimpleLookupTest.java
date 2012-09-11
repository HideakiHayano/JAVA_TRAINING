package ch01.ex01_15;

import junit.framework.TestCase;

import org.junit.Test;

public class SimpleLookupTest extends TestCase{

	@Test
	public void test() {
		
		int numOfContents = 10;
		
		SimpleLookup table = new SimpleLookup(numOfContents);
		
		int index = 0;
		String name = "car";
		Vehicle car = new Vehicle("Roger");
		
		table.add(index, name, car);
		
		//add()test
		assertEquals(name, table.getName(index));
		assertEquals(car, table.getValue(index));
		
		//remove()test
		table.remove(index);
		assertEquals(null, table.getName(index));
		assertEquals(null, table.getValue(index));
		
	}

}
