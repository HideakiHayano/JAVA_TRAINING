package ch11.ex11_01;

public class LinkedList<E>{
	
	private Node<E> node;
	
	public void add(E item){
		Node<E> newNode = new Node<E>(item);
		if(node == null){
			node = newNode;
		}
		else{
			node.setNext(newNode);
			node = newNode;
		}
	}
	
	class Node<E>{
		private Node<E> next;
		private E element;
		
		public Node(E element){
			this.element = element;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setNext(Node<E> next){
			this.next = next;
		}
		
	}
	
	public static void main(String[] args){
		LinkedList<Vehicle> list = new LinkedList<Vehicle>();
		list.add(new Vehicle("Roger"));
		list.add(new Vehicle("Rafael"));
		list.add(new Vehicle("Novak"));

	}
	
}
