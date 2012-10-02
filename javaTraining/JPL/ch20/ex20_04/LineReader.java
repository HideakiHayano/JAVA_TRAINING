package ch20.ex20_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineReader extends FilterReader{
	
	private BufferedReader br;
	
	public LineReader(Reader in) {
		super(in);
		this.br = new BufferedReader(in);
	}
	
	public String readLine() throws Exception{
		String line;
		while((line = br.readLine()) != null){
			return line;
		}
		//impossible
		throw new Exception("Impossible.");
	}
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("test2004.txt");
		BufferedReader br = new BufferedReader(fr);
		LineReader lr = new LineReader(br);
		try {
			System.out.println(lr.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		fr.close();
		br.close();
	}

}
