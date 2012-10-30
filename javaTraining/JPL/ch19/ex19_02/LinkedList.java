package ch19.ex19_02;
/**
 * The LinkedList object defines a list in which each element is linked to the next one.  
 * @author hayano
 *
 */
public class LinkedList {
	/**
	 *The size of the list. 
	 */
	private int listSize;
	/**
	 *The array which consists of all the elements in the list. 
	 */
	private Object[] object;
	/**
	 *The index of the pointed element at the moment. 
	 */
	private int index = 0;
	
	LinkedList(int listSize){
		this.listSize =listSize;
		object = new Object[listSize];
	}
	
	public int getListSize(){
		
		return listSize;
		
	}
	/**
	 * Returns the number of elements included in the list.
	 */
	public int getNumOfContents(){
		
		int numOfContents = 0;
		
		for(int i=0; i<this.listSize; i++){
			
			if(this.object[i] != null){
				numOfContents++;
			}
			
		}
		
		return numOfContents;
	}
	/**
	 * Returns an array which consists of all the elements in the list.
	 * @return
	 */
	public Object[] getList(){
		
		return object;
		
	}
	/**
	 * Returns an element indicated with the index.
	 * @param index 
	 */
	public Object getContent(int index){
		
		return object[index];
		
	}
	
	/**
	 * Add an element to the list.
	 * @param object
	 */
	public void addContent(Object object){
		
	    	if(index <= listSize - 1){
	    		this.object[index] = object;
	    		index++;
	    	}
	    	else{
	    		System.out.println("�e�ʂ�����܂���B");
	    	}
	    
	}
	/**
	 * Add multiple elements to the list.
	 * @param object
	 */
	public void addMultipleContents(Object[] object){
		
	    for(int i=0; i<object.length; i++){
	    	if(index <= listSize - 1){
	    		this.object[index + i] = object[i];
	    		index++;
	    	}
	    	else{
	    		System.out.println("�e�ʂ�����܂���B");
	    		break;
	    	}
	    }
	}
	/**
	 * Returns an index pointed at the moment.
	 * @return
	 */
	public int getIndex(){
		
		return index;
	}
	
	/**
	 * Describes the status of the list.
	 */
	public String toString(){
		
		String elementDesc = "";
		
		for(int i=1; i<=listSize; i++){
			elementDesc = elementDesc + "Vehicle" + i;
			
			if(i != listSize){
				elementDesc = elementDesc + ", ";
			}
			
		}
		
		String desc = "";
		
		desc = 	"LinkedList�̗v�f����" + listSize + "�ł���A�v�f��"
				+ elementDesc + "�ł���";

		return desc;
	}
}
