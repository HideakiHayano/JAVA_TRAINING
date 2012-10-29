package ch21.ex21_06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

public class Concat implements Enumeration{
	
	private String[] streamList;
	private int index;
	private FileInputStream next;
	
	public Concat(String[] streamList){
		this.streamList = streamList;
	}
	
	public static void main(String[] args) throws IOException{
		String[] streamList = {"test2010.txt", "test2101.txt", "test2008.txt"};
		Concat con = new Concat(streamList);
		FileInputStream in;
		while(con.hasMoreElements()){
			in = con.nextElement();
			int ch;
			while((ch = in.read()) != -1){
				System.out.write(ch);
			}
		}
	}

	public boolean hasMoreElements() {
		if(index < 0 || index > streamList.length-1){
			return false;
		}
		if(streamList[index] != null){
			return true;
		}else{
			return false;
		}
	}
	
	public FileInputStream nextElement() {
		if(next != null){
			try {
				next.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileInputStream in = new FileInputStream(streamList[index]);
			index++;
			return in;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Impossible
		System.out.println("Unexpected");
		return null;
	}

}
