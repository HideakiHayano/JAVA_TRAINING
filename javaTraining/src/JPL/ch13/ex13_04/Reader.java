package JPL.ch13.ex13_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {
	
	@SuppressWarnings("rawtypes")
	private ArrayList list = new ArrayList();
	
	public void startInput(){
		System.out.println("Please input the number of data.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			int times = Integer.parseInt(input);
			for(int i =0; i < times; i++){
				input();
			}
		System.out.println("Completed");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void input(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please input data in the format of (type value).");
			String input = br.readLine();
			String[] inputs = input.split((" "));
			
			if(inputs[0].equals("Boolean")){
				Boolean obj = null;
				if(inputs[1] != "true" && inputs[1] != "false"){
					System.out.println("The permitted values are only (true) and (false).");
				}
				else{
					obj = new Boolean(inputs[1]);
				}
				list.add(obj);
			}
			else if(inputs[0].equals("Integer")){
				try{
					Integer.parseInt(inputs[1]);
					Integer obj = new Integer(inputs[1]);
					list.add(obj);
				}catch(NumberFormatException e){
					System.out.println("NumberFormatException");
				}
			}
			else if(inputs[0].equals("Double")){
				try{
					Double.parseDouble(inputs[1]);
					Double obj = new Double(inputs[1]);
					list.add(obj);
				}catch(NumberFormatException e){
					System.out.println("NumberFormatException");
				}
			}
			else if(inputs[0].equals("Float")){
				try{
					Float.parseFloat(inputs[1]);
					Float obj = new Float(inputs[1]);
					list.add(obj);
				}catch(NumberFormatException e){
					System.out.println("NumberFormatException");
				}
			}
			else if(inputs[0].equals("Character")){
				if(inputs[1].length() == 1){
					Character obj = new Character(inputs[1].charAt(0));
					list.add(obj);
				}
				else{
					System.out.println("You can input only one character.");
				}
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList getArray(){
		return list;
	}
	
	public static void main(String[] args) {
		Reader reader = new Reader();
		reader.startInput();
		System.out.println("Your input list is below.");
		for(Object obj : reader.list){
			System.out.println(obj);
		}
	}

}
