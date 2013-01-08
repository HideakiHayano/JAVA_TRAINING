package ch20.ex20_02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TranslateByteFilter extends FilterReader{

	public TranslateByteFilter(Reader in) {
		super(in);
	}
	
	public int read(byte from, byte to){
		int c = 0;
		try {
			c =super.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (c == from ? to : c);
	}
	
	public static void main(String[] args) throws IOException {
		StringReader src = new StringReader("aaa");
		TranslateByteFilter tl = new TranslateByteFilter(src);
		int c;
		//Convert 'a' to 'e'.
		while((c = tl.read((byte)'a', (byte)'e')) != -1){//tl.read() returns the value between 0 and 255.
			System.out.println((char)c);
		}
	}

}
