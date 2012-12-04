package ch23.ex23_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Executor {
	/*
	 * The command will be canceled in case that the the word in this array has been found in the result of the command. 
	 */
	private static String[] errorMessage ={"Unknown"};
	
	public static void main(String[] args) {
		//Create a command.
		StringBuffer command = new StringBuffer("nslookup");
		if(args != null){
			for(int i = 0; i < args.length; i++){
				command.append(" ");
				command.append(args[i]);
			}
		}
		System.out.println(command.toString());
		//Execute a child process.
		Process child = null;
		try {
			child = Runtime.getRuntime().exec(command.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Read a result of the child process.
		InputStream tempIn = child.getInputStream();
		InputStreamReader r = new InputStreamReader(tempIn);
		BufferedReader in = new BufferedReader(r);
		OutputStream tempOut = System.out;
		OutputStreamWriter w = new OutputStreamWriter(tempOut);
		BufferedWriter out = new BufferedWriter(w);
		
		String line;
		int lineNumber = 1;

		try {
			while((line = in.readLine()) != null){
				//If an error has been detected, the subprocess will be destroyed.
				for(int i = 0; i < Executor.errorMessage.length; i++){
					if(line.contains(Executor.errorMessage[i])){
						child.destroy();
					}
				}

				System.out.println(lineNumber + " " + line);
				lineNumber++;
			}
			if(child.waitFor() != 0){
				throw new Exception("Child process has failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
