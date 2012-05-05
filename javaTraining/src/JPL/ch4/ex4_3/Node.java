package JPL.ch4.ex4_3;

public class Node{
	private Object obj;
	private Node next;
	
	public Node(){
		this.obj = null;
		this.next = null;
	}
	
	public Node(Object obj, Node next){
		this.obj = obj;
		this.next = next;
	}
	
	public Object getObject(){
		return obj;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setObject(Object obj){
		this.obj = obj;
	}
	
	public void setNext(Node node){
		this.next = node;
	}
	
}
