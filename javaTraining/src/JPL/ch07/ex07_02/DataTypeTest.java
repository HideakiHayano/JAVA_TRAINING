package JPL.ch7.ex7_2;

public class DataTypeTest {

	/**
	 * @param args
	 */
	boolean bool = true;
	char c = 'c';
	byte b = 2;
	short s = 1;
	int i = 1;
	long l = 1;
	float f = 1.0f;
	double d = 1.0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataTypeTest test = new DataTypeTest();
		test.i = -1/0; 
		test.i = (int) 3.5f;
		test.d = 2l;
		//test.s = (short) 10000000000000000000;
		test.b = (byte) test.s;
		test.f = test.l;
		test.c = (char) test.i;
		//test.bool = 1;
	}

}
