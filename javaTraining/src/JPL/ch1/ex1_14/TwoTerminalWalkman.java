package JPL.ch1.ex1_14;

public class TwoTerminalWalkman extends Walkman{

	private static final int NUM_OF_TERMINAL = 2;
	
	private static int[] terminalID;
	
	static{
		
		terminalID = new int[NUM_OF_TERMINAL];
		
		for(int i=0; i<NUM_OF_TERMINAL; i++){
			
			terminalID[i] = i;
			
		}
		
	}
	
}
