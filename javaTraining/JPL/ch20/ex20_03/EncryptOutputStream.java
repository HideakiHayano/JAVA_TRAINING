package ch20.ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream{

	public EncryptOutputStream(OutputStream out) {
		super(out);
	}
	
	public void write(int b){
		try {
			System.out.println("before encryption: " + b);
			super.write(encrypt(b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int encrypt(int b){
		return b^0;
	}
	
}
