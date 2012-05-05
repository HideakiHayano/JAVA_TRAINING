package JPL.ch4.ex4_2;

import JPL.ch3.ex3_9.Vehicle;

//sort():引数としてidとオブジェクトを関連付けた配列を渡し、idをもとに昇順にオブジェクトを並び変える.

public class SortHarness implements Sort{
	
	Map map;
	
	public SortHarness(int mapSize){
		map = new Map(3);
	}
	
	public void sort(Map map){
		for(int i = 0; i < map.getIDList().length; i++){
			for(int j = i+1; j < map.getIDList().length; j++){
				if(map.getIDList()[i] > map.getIDList()[j]){
					swap(i, j);
				}
			}
		}
	}
	
	private void swap(int i, int j){
		Object temp = map.getList()[i];
		map.getList()[i] = map.getList()[j];
		map.getList()[j] = temp;
	}
	
	public static void main(String[] args){
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		Vehicle vehicle3 = new Vehicle();
		
		SortHarness sortHarness = new SortHarness(3);
		
		sortHarness.map.put(120, vehicle1);
		sortHarness.map.put(70, vehicle2);
		sortHarness.map.put(340, vehicle3);
		
		sortHarness.sort(sortHarness.map);
		
		for(int i = 0; i < sortHarness.map.getIDList().length; i++){
			System.out.println(sortHarness.map.getList()[i]);
		}
	}
	
//	class Map{
//		private int[] id;
//		private Object[] list;
//		private int top = 0;
//		
//		public Map(int size){
//			id = new int[size];
//			list = new Object[size];
//		}
//		
//		public void put(int i, Object obj){
//			id[top] = i;
//			list[top] = obj;
//			top++;
//		}
//		
//		public int getID(int i){
//			if(i < 0 || i > list.length){
//				return 0;
//			}
//			else{ 
//				return id[i];
//			}
//		}
//		
//		public Object getListElement(int i){
//			if(i < 0 || i > list.length){
//				return null;
//			}
//			else{ 
//				return list[i];
//			}
//		}
//	}
	
}
