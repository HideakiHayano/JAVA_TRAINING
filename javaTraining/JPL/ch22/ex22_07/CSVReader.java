package ch22.ex22_07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CSVReader {
	
	public static List<String[]> readCSVTable(Readable source, int numOfCells)throws IOException{
		final int CELLS = numOfCells;
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		StringBuffer exp = new StringBuffer("^");
		for(int i = 0; i < numOfCells; i++){
			exp.append("(.*)");
			if(i != numOfCells-1){
				exp.append(",");
			}
		}
		Pattern pat = Pattern.compile(exp.toString(), Pattern.MULTILINE);
		while(in.hasNextLine()){
			String line = in.findInLine(pat);
			if(line != null){
				String[] cells = new String[CELLS];
				MatchResult match = in.match();
				for(int i = 0; i < CELLS; i++){
					cells[i] = match.group(i+1);
				}
				vals.add(cells);
				in.nextLine();//Skip a line feed.
			}
			else{
				throw new IOException("input format error");
			}
		}
		
		IOException ex = in.ioException();
		if(ex != null)
			throw ex;
		
		return vals;
	}
	
	public static void main(String[] args) {

	}

}
