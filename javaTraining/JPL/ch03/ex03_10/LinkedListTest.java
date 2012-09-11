package ch03.ex03_10;

import junit.framework.TestCase;

import org.junit.Test;

import ch03.ex03_09.Vehicle;

public class LinkedListTest extends TestCase{

	@Test
	//clone()�ŃR�s�[���Ɠ������X�g���Q�Ƃ���I�u�W�F�N�g����ꂽ���e�X�g����B
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
		
		//���郊�X�g�Q�Ƃ�p���ă��X�g�ɔƍs��������ƁA���̃��X�g�Q�Ƃ���ύX�����邱�Ƃ��ł���B
		list.addContent(vehicle3);
		assertEquals(true, list.getContent(2).equals(test.getContent(2)));
		
	}

}
