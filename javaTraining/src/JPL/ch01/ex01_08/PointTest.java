package JPL.ch1.ex1_8;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {
		
		Point point = new Point();
		point.x = 1.5;
		point.y = 2.0;
		
		Point testedPoint = new Point();
		
		testedPoint.move(point);
		
		//double‚Ìtest‚É‚Í‹–—eŒë·‚ğˆø”‚Æ‚·‚é•K—v‚ª‚ ‚é
		assertEquals(1.5, testedPoint.x, 0.001);
		assertEquals(2.0, testedPoint.y, 0.001);
		
	}

}
