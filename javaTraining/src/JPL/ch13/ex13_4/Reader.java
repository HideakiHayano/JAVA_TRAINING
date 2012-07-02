package JPL.ch13.ex13_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {
	
	private ArrayList list = new ArrayList();
	
	public void startInput(){
		System.out.println("��������I�u�W�F�N�g�̐�");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			int times = Integer.parseInt(input);
			for(int i =0; i < times; i++){
				input();
			}
		System.out.println("���X�g�쐬����");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void input(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("��������I�u�W�F�N�g�̌^�ƒl�Ftype value");
			String input = br.readLine();
			String[] inputs = input.split((" "));
			
			if(inputs[0].equals("Boolean")){
				Boolean obj;
				if(inputs[1] != "true" || inputs[1] != "false"){
					System.out.println("�^�ɍ���Ȃ��l�����͂���܂����B�lfalse�Ƃ݂Ȃ��܂�");
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
					System.out.println("�G���[�F�l���^�ɑΉ����Ă��܂���");
				}
			}
			else if(inputs[0].equals("Double")){
				try{
					Double.parseDouble(inputs[1]);
					Double obj = new Double(inputs[1]);
					list.add(obj);
				}catch(NumberFormatException e){
					System.out.println("�G���[�F�l���^�ɑΉ����Ă��܂���");
				}
			}
			else if(inputs[0].equals("Float")){
				try{
					Float.parseFloat(inputs[1]);
					Float obj = new Float(inputs[1]);
					list.add(obj);
				}catch(NumberFormatException e){
					System.out.println("�G���[�F�l���^�ɑΉ����Ă��܂���");
				}
			}
			else if(inputs[0].equals("Character")){
				if(inputs[1].length() == 1){
					Character obj = new Character(inputs[1].charAt(0));
					list.add(obj);
				}
				else{
					System.out.println("����1�̕����݂̂����͉\");
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
