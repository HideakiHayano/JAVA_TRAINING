package ch01.ex01_15;

public class SimpleLookup implements ModifiedLookup{
	
	private String[] names;
	private Object[] values;
	
//	void processValues(String[] names, Lookup table){
//		for(int i=0; i< names.length; i++){
//			Object value = table.find(names[i]);
//		}
//	}
	public SimpleLookup(int numOfContents){
		
		names = new String[numOfContents];
		values = new Object[numOfContents];
		
	}
	
	
	public String getName(int index){
		return names[index];
	}
	
	public Object getValue(int index){
		return values[index];
	}
	
	public Object find(String name){
		for(int i=0; i<names.length; i++){
			if(names[i].equals(name)){
				return values[i];
			}
		}
		return null;
	}
	
	public void add(int index, String name, Object value){
		if(index >= 0 && index < names.length){
			names[index] = name;
			values[index] = value;
		}
		else
			System.out.println("add():�w�肳�ꂽ�C���f�b�N�X�͖���");
	}
	
	public void remove(int index){
		
		if(names[index] != null && values[index] != null){
			
			names[index] = null;
			values[index] = null;
		
		}
		
	}
	
}
