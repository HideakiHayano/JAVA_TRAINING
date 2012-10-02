package ch20.ex20_01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.SequenceInputStream;

public class Translator {

	public static OutputStream translate(byte from, byte to, InputStream inputStream, String outputFileName)throws IOException{
		int b;
		OutputStream outputStream;
		
		if(inputStream instanceof ObjectInputStream){
			outputStream = new ByteArrayOutputStream();
		}
		else if(inputStream instanceof SequenceInputStream){
			outputStream = new ByteArrayOutputStream();
		}
		else if(inputStream instanceof ByteArrayInputStream){
			outputStream = new ByteArrayOutputStream();
		}
		else if(inputStream instanceof PipedInputStream){
			outputStream = new PipedOutputStream();
		}
		else if(inputStream instanceof FileInputStream){
			outputStream = new FileOutputStream(outputFileName);
		}
		else{//impossible
			throw new IOException("The designated inputstream is invalid.");
		}
		while((b = inputStream.read()) != -1){
			outputStream.write(b == from ? to : b);
			System.out.println(b == from ? to : b);
		}
		return outputStream;
	}
	
	public static void main(String[] args) throws Throwable {
		byte[] argByte = new byte[3];
		argByte[0] = (byte)'a';
		argByte[1] = (byte)'b';
		argByte[2] = (byte)'c';
		
		ByteArrayInputStream byteInputStream = new ByteArrayInputStream(argByte);
		
		Translator.translate((byte)'a', (byte)'z', byteInputStream, null);
		byteInputStream.close();
	}

}
