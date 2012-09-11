package ch12.ex12_01;

public class ObjectNotFoundException extends Exception{
	public final String errorMessage;
	
	public ObjectNotFoundException(String name){
		errorMessage = name + " �͌was not found.";
		System.out.println(errorMessage);
	}
	
}
