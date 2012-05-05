package JPL.ch5.ex5_1;

public interface Attributed {
	
	void add(Attr attr);
	
	class Attr{
		private String name;
		private Object value;
		
		Attr(String name, Object value){
			this.name = name;
			this.value = value;
		}
		
	}
	
}
