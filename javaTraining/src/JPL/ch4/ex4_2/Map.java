package JPL.ch4.ex4_2;

public class Map {
	private int[] id;
	private Object[] list;
	private int top = 0;
	
	public Map(int size){
		id = new int[size];
		list = new Object[size];
	}
	
	public void put(int i, Object obj){
		id[top] = i;
		list[top] = obj;
		top++;
	}
	
	public int[] getIDList(){
		return id;
	}
	
	public Object[] getList(){
		return list;
	}
	
	public int getID(int i){
		if(i < 0 || i > list.length){
			return 0;
		}
		else{ 
			return id[i];
		}
	}
	
	public Object getListElement(int i){
		if(i < 0 || i > list.length){
			return null;
		}
		else{ 
			return list[i];
		}
	}
}
