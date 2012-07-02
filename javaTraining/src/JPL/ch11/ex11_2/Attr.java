package JPL.ch11.ex11_2;

public class Attr<E> {

	private final String name;
	private E value = null;
	
	public Attr(String name){
		this.name = name;
	}
	
	public Attr(String name, E value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public E getValue(){
		return value;
	}
	
	public E setValue(E newValue){
		E oldValue = value;
		value = newValue;
		return oldValue;
	}
	
	public String toString(){
		return name + "='" + value + "'";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Attr<String> attr = new Attr<String>("score", "100");
		System.out.println(attr.getName() + ":" + attr.getValue());
		
		//Stringしか引数にとらないのでコンパイルエラー
		//attr.setValue(5);
	}

}
