package ch21.ex21_07;

import java.util.ArrayList;

public class MyStack<E> extends ArrayList<E>{
	
	public MyStack(){
		super();
	}
	
	public boolean empty(){
		if(this.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public E push(E item){
		//copy
		ArrayList<E> temp = (ArrayList<E>) this.clone();
		for(int i = 0; i < temp.size(); i++){
			this.add(i+1, temp.get(i));
		}
		super.add(0, item);
		return item;
	}
	
	public E pop(){
		return this.remove(0);
	}
	
	public E peek(){
		return this.get(0);
	}
	
	public int search(Object o) throws Exception{
		if(this.contains(o))
			return this.indexOf(o);
		else
			throw new Exception("No Such Element");
	}
	
	public static void main(String[] args) throws Exception {
		MyStack stack = new MyStack();
		stack.add("str0");
		stack.add("str1");
		stack.add("str2");
		System.out.println("The index of str0 is " + stack.search("str0")+".");
		stack.push("new");
		System.out.println(stack.get(0));
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

}
