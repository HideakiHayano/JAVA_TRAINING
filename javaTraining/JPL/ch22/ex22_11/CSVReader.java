package ch22.ex22_11;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	public static List<String> readCSVTable(Reader source, int numOfCells)throws IOException{
		final int CELLS = numOfCells;
		List<String> result = new ArrayList();
		StreamTokenizer in = new StreamTokenizer(source);
		while(in.nextToken() != StreamTokenizer.TT_EOF){
			if(in.ttype == StreamTokenizer.TT_WORD){
				result.add(in.sval);
			}
		}		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(new File("test.csv"));
		List result = CSVReader.readCSVTable(fr, 4);
		for(int i = 0; i < result.size(); i++){
			System.out.printf((String)result.get(i));
			if(i != result.size()-1){
				System.out.printf(",");
			}
		}
	}
}
