package JPL.ch12.ex12_1;

public class ObjectNotFoundException extends Exception{
	public final String errorMessage;
	
	public ObjectNotFoundException(String name){
		errorMessage = name + "�͌�����܂���ł���";
		System.out.println(errorMessage);
	}
	
}
