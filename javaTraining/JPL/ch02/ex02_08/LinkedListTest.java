package ch02.ex02_08;

import ch02.ex02_08.LinkedList;
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
