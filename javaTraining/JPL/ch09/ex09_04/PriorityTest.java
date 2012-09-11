package ch09.ex09_04;

public class PriorityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(3<<2L-1);//3��(2-1)�������r�b�g�V�t�g
		System.out.println(10<12==6>17);
		System.out.println(10<<17==6>>17);
		System.out.println(13.5e-1%Float.POSITIVE_INFINITY);
		System.out.println(Float.POSITIVE_INFINITY-Double.NEGATIVE_INFINITY);
		System.out.println(-0.0/0.0==-0.0/0.0);
		System.out.println(Integer.MAX_VALUE+Integer.MIN_VALUE);
		System.out.println(Long.MAX_VALUE+5);
		System.out.println((short)5*(byte)10);
		System.out.println(10<15?1.72e3f:0);
		int i=3;
		System.out.println(i++ + i++ + --i);
	}

}
