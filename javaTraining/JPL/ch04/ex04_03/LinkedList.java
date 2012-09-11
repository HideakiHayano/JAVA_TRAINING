package ch04.ex04_03;

public class LinkedList implements List{
	
	private Node start;
	private int size;
	private Node ref;
	
	LinkedList(){
		this.start = new Node();
		this.size = 0;
	}
	
	public Node getContent(int n){
		Node ref = start;
		int i = -1;
		
		while(ref != null){
			if(n == i){
				return ref;
			}
			i++;
			ref = ref.getNext();
		}
		return null;
	}
	
	public int getListSize(){
		return size;
	}
	
	public void add(int n, Object object){
		Node ref1 = getContent(n-1);
		Node newNode = new Node(object, ref1.getNext());
		ref1.setNext(newNode);
		this.size++;
	}
	
	public void remove(int n){
		Node ref1 = getContent(n-1);
		Node ref2 = getContent(n);
		ref1.setNext(ref2.getNext());
		ref2.setNext(null);
    }
	
	public void next(){
		ref =  ref.getNext();
	}
	
	public boolean hasNext(){
		if(ref.getNext() != null)
			return true;
		else
			return false;
	}
	
	
	
//	public String toString(){
//		
//		String elementDesc = "";
//		
//		for(int i=1; i<=listSize; i++){
//			elementDesc = elementDesc + "Vehicle" + i;
//			
//			if(i != listSize){
//				elementDesc = elementDesc + ", ";
//			}
//			
//		}
//		
//		String desc = "";
//		
//		desc = 	"LinkedList�̗v�f����" + listSize + "�ł���A�v�f��"
//				+ elementDesc + "�ł���";
//
//		return desc;
//	}
	public static void main(String[] args){
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		Vehicle vehicle3 = new Vehicle();
		
		LinkedList list = new LinkedList();
		list.add(0, vehicle1);
		list.add(1, vehicle2);
		list.add(2, vehicle3);
		
		System.out.println(list.getListSize());
		System.out.println(list.getContent(0));
		System.out.println(list.getContent(1));
		System.out.println(list.getContent(2));
		
	}
	
}
