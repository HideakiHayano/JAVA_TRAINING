package JPL.ch2.ex2_11;

public class LinkedList {
	public int numOfElements;
	public Object[] object;
	public static int id = 0;
	
	LinkedList(int numOfElements){
		this.numOfElements =numOfElements;
		object = new Object[numOfElements];
	}
	
	public void add(Object object){
		this.object[id] = object;
		id++;
	}
	
	public String toString(){
		
		String elementDesc = "";
		
		for(int i=1; i<=numOfElements; i++){
			elementDesc = elementDesc + "Vehicle" + i;
			
			if(i != numOfElements){
				elementDesc = elementDesc + ", ";
			}
			
		}
		
		String desc = "";
		
		desc = 	"LinkedList‚Ì—v‘f”‚Í" + numOfElements + "‚Å‚ ‚èA—v‘f‚Í"
				+ elementDesc + "‚Å‚ ‚é";

		return desc;
	}
	
}
