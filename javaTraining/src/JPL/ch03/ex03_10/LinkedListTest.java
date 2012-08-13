package JPL.ch3.ex3_10;

import junit.framework.TestCase;

import org.junit.Test;

import JPL.ch3.ex3_9.Vehicle;

public class LinkedListTest extends TestCase{

	@Test
	//clone()でコピー元と同じリストを参照するオブジェクトを作れたかテストする。
	public void testClone() {
		LinkedList list = new LinkedList(3);
		
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		Vehicle vehicle3 = new Vehicle();
		
		list.addContent(vehicle1);
		list.addContent(vehicle2);

		LinkedList test = list.clone();
		
		for(int i = 0; i < list.getListSize()-1; i++){
			assertEquals(true, list.getContent(i).equals(test.getContent(i)));
		}
		
		//あるリスト参照を用いてリストに犯行を加えると、他のリスト参照から変更を見ることができる。
		list.addContent(vehicle3);
		assertEquals(true, list.getContent(2).equals(test.getContent(2)));
		
	}

}
