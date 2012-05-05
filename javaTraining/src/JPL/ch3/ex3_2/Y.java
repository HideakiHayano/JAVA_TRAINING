package JPL.ch3.ex3_2;

public class Y extends X{
	protected int yMask = 0xff00;
	
	public Y(){
		System.out.println("Y1");
		System.out.printf("xMask:, fullMask: yMask:, %x, %x, %x", xMask, fullMask, yMask);
		System.out.println();
		fullMask |= yMask;
		System.out.println("Y2");
		System.out.printf("xMask:, fullMask: yMask:, %x, %x, %x", xMask, fullMask, yMask);
		System.out.println();
	}
}
