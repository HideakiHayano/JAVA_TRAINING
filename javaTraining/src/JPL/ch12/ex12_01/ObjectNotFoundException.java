package JPL.ch12.ex12_1;

public class ObjectNotFoundException extends Exception{
	public final String errorMessage;
	
	public ObjectNotFoundException(String name){
		errorMessage = name + "は見つかりませんでした";
		System.out.println(errorMessage);
	}
	
}
