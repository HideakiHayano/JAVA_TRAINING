package ch23.ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

public class StreamPlugThread extends Thread{
	
	public static void plugTogether(InputStream in, OutputStream out){
		int c = 0;
		try {
			while((c = in.read()) != -1){
				out.write((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void plugTogether(OutputStream out, InputStream in){
		//The same as above.
		int c = 0;
		try {
			while((c = in.read()) != -1){
				out.write((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Process userProg(String cmd) throws IOException{
		Process proc = Runtime.getRuntime().exec(cmd);
		//plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		//plugTogether(System.err, proc.getErrorStream());
		return proc;
	}
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		String cmd = "ipconfig";
		try {
			StreamPlugThread.userProg(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
