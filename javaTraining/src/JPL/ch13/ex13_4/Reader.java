package JPL.ch13.ex13_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {
	
	private ArrayList list = new ArrayList();
	
	public void startInput(){
		System.out.println("生成するオブジェクトの数");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			int times = Integer.parseInt(input);
			for(int i =0; i < times; i++){
				input();
			}
		System.out.println("リスト作成完了");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void input(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("生成するオブジェクトの型と値：type value");
			String input = br.readLine();
			String[] inputs = input.split((" "));
			
			if(inputs[0].equals("Boolean")){
				Boolean obj;
				if(inputs[1] != "true" || inputs[1] != "false"){
					System.out.println("型に合わない値が入力されました。値falseとみなします");
					obj = new Boolean(inputs[1]);
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
					System.out.println("エラー：値が型に対応していません");
				}
			}
			else if(inputs[0].equals("Double")){
				try{
					Double.parseDouble(inputs[1]);
					Double obj = new Double(inputs[1]);
					list.add(obj);
				}catch(NumberFormatException e){
					System.out.println("エラー：値が型に対応していません");
				}
			}
			else if(inputs[0].equals("Float")){
				try{
					Float.parseFloat(inputs[1]);
					Float obj = new Float(inputs[1]);
					list.add(obj);
				}catch(NumberFormatException e){
					System.out.println("エラー：値が型に対応していません");
				}
			}
			else if(inputs[0].equals("Character")){
				if(inputs[1].length() == 1){
					Character obj = new Character(inputs[1].charAt(0));
					list.add(obj);
				}
				else{
					System.out.println("長さ1の文字のみが入力可能");
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
		System.out.println(reader.getArray().get(0).equals(new Integer(3)));
		System.out.println(reader.getArray().get(1).equals(new Double(3.5)));
	}

}
