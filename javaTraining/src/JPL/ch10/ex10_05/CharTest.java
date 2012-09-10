package JPL.ch10.ex10_05;

public class CharTest {
	
	public void showCharList(char start, char end){
		if(start <= end){
			for(char i = start; i <= end; i++){
				System.out.println(i);
			}
		}
		else{
			for(char i = end; i <= start; i++){
				System.out.println(i);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharTest test = new CharTest();
		char start = '��';
		char end = '��';
		test.showCharList(start, end);
	}

}
