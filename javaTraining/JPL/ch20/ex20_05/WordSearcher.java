package ch20.ex20_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class WordSearcher {
	public static void search(String fileName, String searchWord) throws IOException{
		FileReader fileIn = new FileReader(fileName);
		LineNumberReader in = new LineNumberReader(fileIn);
		int ch;
		int i = 0;
		boolean match = false;//Flag to show the search word will be found
		
		String temp;
		
		while((temp = in.readLine()) != null){
			if(temp.contains(searchWord)) {
				System.out.println(in.getLineNumber() + ": " +temp);
			}
		}
		
		fileIn.close();
		in.close();
	}
	
	public static void main(String[] args) {
		try {
			WordSearcher.search("test2005.txt", "pen");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
