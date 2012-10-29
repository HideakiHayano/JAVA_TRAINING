package ch22.ex22_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import ch22.ex22_09.CSVReader;

public class MyScanner {
	String[] delimiter = {"#.*", ","};
	
	public List<String> readExceptComment(Readable source){
		Scanner in = new Scanner(source);
		Scanner in2;
		List result = new ArrayList();
		in.useDelimiter("#.*\\r\\n");
		while(in.hasNext()){
			result.add(in.next());
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(new File("test2210.txt"));
		MyScanner scan = new MyScanner();
		List list = scan.readExceptComment(fr);
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
