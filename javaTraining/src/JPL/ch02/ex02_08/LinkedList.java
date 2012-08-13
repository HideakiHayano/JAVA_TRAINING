package JPL.ch2.ex2_8;

public class LinkedList {
	public int numOfElements;
	public Object[] object;
	public static int id = 0;
	
	//リストに格納する数を決めるコンストラクタ
	public LinkedList(int numOfElements){
		this.numOfElements =numOfElements;
		object = new Object[numOfElements];
	} 
}
