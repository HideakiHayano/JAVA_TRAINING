package JPL.ch3.ex3_10;

public class LinkedList implements Cloneable{
	//Objectフィールドにはset,getメソッドを追加
	//listSize, indexにはgetメソッドのみ追加
	
	private int listSize;
	private Object[] object;
	private int index = 0;
	
	//////////////////////////////////////
	//ex3_10
	public LinkedList clone(){
		LinkedList newList;
		try {
			newList = (LinkedList)super.clone();
			return newList;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	//////////////////////////////////////
	
	LinkedList(int listSize){
		this.listSize =listSize;
		object = new Object[listSize];
	}
	
	public int getListSize(){
		
		return listSize;
		
	}
	//追加
	public int getNumOfContents(){
		
		int numOfContents = 0;
		
		for(int i=0; i<this.listSize; i++){
			
			if(this.object[i] != null){
				numOfContents++;
			}
			
		}
		
		return numOfContents;
	}
	//
	
	public Object[] getList(){
		
		return object;
		
	}
	
	public Object getContent(int index){
		
		return object[index];
		
	}
	
	public void addContent(Object object){
		
	    	if(index <= listSize - 1){
	    		this.object[index] = object;
	    		index++;
	    	}
	    	else{
	    		System.out.println("容量が足りません。");
	    	}
	    
	}
	
	public void addMultipleContents(Object[] object){
		
	    for(int i=0; i<object.length; i++){
	    	if(index <= listSize - 1){
	    		this.object[index + i] = object[i];
	    		index++;
	    	}
	    	else{
	    		System.out.println("容量が足りません。");
	    		break;
	    	}
	    }
	}
	
	public int getIndex(){
		
		return index;
	}
	
	public String toString(){
		
		String elementDesc = "";
		
		for(int i=1; i<=listSize; i++){
			elementDesc = elementDesc + "Vehicle" + i;
			
			if(i != listSize){
				elementDesc = elementDesc + ", ";
			}
			
		}
		
		String desc = "";
		
		desc = 	"LinkedListの要素数は" + listSize + "であり、要素は"
				+ elementDesc + "である";

		return desc;
	}
}
