package JPL.ch2.ex2_8;

import JPL.ch2.ex2_8.LinkedList;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		int numOfElements = 3;
		
		LinkedList list = new LinkedList(numOfElements);
		
		assertEquals(numOfElements, list.numOfElements);
	}

}
