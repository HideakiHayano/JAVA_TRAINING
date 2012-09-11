package ch03.ex03_10;

public class LinkedList implements Cloneable{
	//Object�t�B�[���h�ɂ�set,get���\�b�h��ǉ�
	//listSize, index�ɂ�get���\�b�h�̂ݒǉ�
	
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
	//�ǉ�
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
	    		System.out.println("�e�ʂ�����܂���B");
	    	}
	    
	}
	
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
		
		desc = 	"LinkedList�̗v�f����" + listSize + "�ł���A�v�f��"
				+ elementDesc + "�ł���";

		return desc;
	}
}
