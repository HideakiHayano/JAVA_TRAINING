package ch21.ex21_01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SortListMaker extends FilterReader{
	
	private List<String> strList = new LinkedList<String>();
	private BufferedReader br;
	
	public SortListMaker(FileReader in) throws FileNotFoundException {
		super(in);
		this.br = new BufferedReader(in);
	}
	/**
	 * Make a list by sorting lines in the file.
	 * @return list
	 * @throws Exception
	 */
	public List<String> makeSortedList() throws Exception{
		String line;
		while((line = br.readLine()) != null){
			if(!line.equals(null) && !line.equals("")){
				add(line);
			}
		}
		return strList;
	}
	
	private void add(String str){
		if(strList.isEmpty()){
			strList.add(str);
		}
		else{
			for(int i = 0; i < strList.size(); i++){
				if(str.compareTo(strList.get(i)) <= 0){
					//Add str to the ith element and move the latter elements by one.
					strList.add(i, str);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("test2101.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		SortListMaker slm = null;
		
		try {
			slm = new SortListMaker(fr);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			List list = slm.makeSortedList();
			System.out.println("sorted result: ");
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
