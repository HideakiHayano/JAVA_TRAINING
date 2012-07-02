package JPL.ch12.ex12_1;

public class LinkedList<E>{
	
	private Node<E> node;
	private Node<E> firstNode;
	private int numOfElements;
	
	
	public void add(String key, E item){
		Node<E> newNode = new Node<E>(key, item);
		if(node == null){
			node = newNode;
			firstNode = newNode;
			numOfElements++;
		}
		else{
			node.setNext(newNode);
			node = newNode;
			numOfElements++;
		}
	}
	
	/**
	 * Nodeのkeyをもとに検索
	 * @param key Nodeを識別するためのkey
	 * @return
	 */
	public Node<E> find(String key)throws ObjectNotFoundException{
		Node<E> top = firstNode;
		
		for(int i=0; i<numOfElements; i++){
			if(key.equals(top.key) == false){//keyが一致しなければ次の要素へ
				top = top.getNext();
			}
			else{//keyが一致すればreturn
				System.out.println(key + "が見つかりました!!");
				return top;
			}
		}
		throw new ObjectNotFoundException(key);
	}
	
	class Node<E>{
		private Node<E> next;
		private E element;
		private String key;
		
		public Node(String key, E element){
			this.key = key;
			this.element = element;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setNext(Node<E> next){
			this.next = next;
		}
		
		public String getKey(){
			return key;
		}
	}
	
	public static void main(String[] args){
		LinkedList<Vehicle> list = new LinkedList<Vehicle>();
		list.add("RogerCar", new Vehicle("Roger"));
		list.add("RafaelCar", new Vehicle("Rafael"));
		list.add("NovakCar", new Vehicle("Novak"));
		
		try {
			list.find("NovakCar");
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			list.find("飛行機");
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}

	}
	
}
