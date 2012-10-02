package ch21.ex21_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;

public class DataHandler {
	
	private static String KEY_LASTFILE = "lastFile";
	private static String KEY_LASTDATA = "lastData";
	
	private WeakHashMap<String, Object> hash; 
	
	byte[] readFile(File file) throws IOException{
		byte[] data;
		
		//Check if the data is kept
		if(file.equals(hash.get(KEY_LASTFILE))){
			data = (byte[]) hash.get(KEY_LASTDATA);
			if(data != null){
				return data;
			}
		}
		
		//The data is not kept, so read it
		data = readBytesFromFile(file);
		hash = new WeakHashMap<String, Object>();
		hash.put(KEY_LASTFILE, file);
		hash.put(KEY_LASTDATA, data);
		return data;
		
	}
	
	private byte[] readBytesFromFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    // Get the size of the file
	    long length = file.length();

	    // You cannot create an array using a long type.
	    // It needs to be an int type.
	    // Before converting to an int type, check
	    // to ensure that file is not larger than Integer.MAX_VALUE.
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }

	    // Create the byte array to hold the data
	    byte[] bytes = new byte[(int)length];

	    // Read in the bytes
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    // Ensure all the bytes have been read in
	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    // Close the input stream and return bytes
	    is.close();
	    return bytes;
	}
	
	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		try {
			dh.readFile(new File("test2102.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
