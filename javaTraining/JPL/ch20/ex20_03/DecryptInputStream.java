package ch20.ex20_03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream{

	public DecryptInputStream(InputStream in) {
		super(in);
	}
	
	public int read(){
		int c = 0;
		try {
			c = super.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return decrypt(c);
	}
	
	private int decrypt(int c){
		//Failed to encrypt data??
		//In case that I use the value below, a wrong result is obtained,
		//which means there is a difference between the values before encryption and those after decryption.
		//return c^1;
		return c;
	}
	
	public static void main(String[] args) throws IOException{
		String test = "This is a pen.";
		byte[] value = new byte[20];
		for(int i = 0; i < test.length(); i++){
			value[i] = (byte) test.charAt(i);
		}
		EncryptOutputStream e = new EncryptOutputStream(new FileOutputStream("test2003"));
		for(int i = 0; i < value.length; i++){
			e.write(value[i]);
		}
		DecryptInputStream d = new DecryptInputStream(new FileInputStream("test2003"));
		int c = 0;
		for(; ;){
			if((c = d.read()) != -1){
				System.out.println("after decryption : " + c);
				e.close();
				d.close();
			}
		}

	}
}
