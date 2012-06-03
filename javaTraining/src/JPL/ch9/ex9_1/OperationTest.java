package JPL.ch9.ex9_1;

public class OperationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Float.POSITIVE_INFINITY/Float.MIN_VALUE);
		System.out.println(Float.POSITIVE_INFINITY*Float.MIN_VALUE);
		System.out.println(Float.POSITIVE_INFINITY*(-0.0));
		System.out.println(0.0/0.0);
		System.out.println(5%Float.POSITIVE_INFINITY);
	}

}
