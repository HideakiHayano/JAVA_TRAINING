package JPL.ch3.ex3_2;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	public X(){
		System.out.println("X1");
		System.out.printf("xMask:, fullMask:, %x, %x", xMask, fullMask);
		System.out.println();
		fullMask = xMask;
		System.out.println("X2");
		System.out.printf("xMask:, fullMask:, %x, %x", xMask, fullMask);
		System.out.println();
	}
	
	public int mask(int orig){
		return (orig & fullMask);
	}
	
}




