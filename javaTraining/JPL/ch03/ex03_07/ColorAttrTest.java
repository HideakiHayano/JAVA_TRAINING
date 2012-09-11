package ch03.ex03_07;

import junit.framework.TestCase;

import org.junit.Test;

public class ColorAttrTest extends TestCase{

	@Test
	public void testEquals1() {
		ColorAttr colorAttr = new ColorAttr("attr1", new ScreenColor(80));
		ColorAttr test = colorAttr;
		
		assertEquals(true, colorAttr.equals(test));
	}

	public void testEquals2() {
		//���O����������Γ���̂��̂Ƃ݂Ȃ�
		ColorAttr colorAttr = new ColorAttr("attr1", new ScreenColor(80));
		ColorAttr test = new ColorAttr("attr1", new ScreenColor(60));
		
		System.out.println(colorAttr.hashCode());
		System.out.println(test.hashCode());
		
		System.out.println(colorAttr.getName().hashCode());
		System.out.println(test.getName().hashCode());
		
		assertEquals(true, colorAttr.equals(test));
	}
	
	public void testEquals3() {
		//���O���قȂ�Εʂ̂��̂Ƃ݂Ȃ�
		ColorAttr colorAttr = new ColorAttr("attr1", new ScreenColor(80));
		ColorAttr test = new ColorAttr("attr2", new ScreenColor(80));
		
		assertEquals(false, colorAttr.equals(test));
	}
	
	public void testEquals4() {
		//�^���قȂ�Εʂ̂��̂Ƃ݂Ȃ�
		ColorAttr colorAttr = new ColorAttr("attr1", new ScreenColor(80));
		String test = "test";
		
		assertEquals(false, colorAttr.equals(test));
	}
	
}
