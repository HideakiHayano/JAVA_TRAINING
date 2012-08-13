package JPL.ch14.ex14_7;

//yield()でスレッドの優先順位を決める。アプリケーション実行のたびにスレッドの実行順は異なる。

public class Babble extends Thread{
	
	static boolean doYield;
	static int howOften;
	private String word;
	
	Babble(String whatToSay){
		word = whatToSay;
	}
	
	public void run(){
		for(int i = 0; i < howOften; i++){
			System.out.println(word);
			if(doYield)
				Thread.yield();
		}
	}
	
	public static void main(String[] args){
		String[] elements = {"true", "3", "Do", "DoNot"}; 
	    doYield = new Boolean(elements[0]).booleanValue();
		howOften = Integer.parseInt(elements[1]);
		
		for(int i = 2; i < elements.length; i++){
			new Babble(elements[i]).start();
		}
	}
	
}
