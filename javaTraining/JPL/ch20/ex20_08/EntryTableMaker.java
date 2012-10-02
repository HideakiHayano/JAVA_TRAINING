package ch20.ex20_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntryTableMaker extends RandomAccessFile{

	public EntryTableMaker(String fileName, String mode) throws FileNotFoundException {
		super(fileName, mode);
	}
	
	/**
	 * Read a file and return a entry table. 
	 * @param fileName
	 * @return entry
	 * @throws IOException
	 */
	public List<Byte> readEntry(String fileName) throws IOException{
		String temp = null;
		List<Byte> entryTable = new ArrayList<Byte>();
		while((temp = super.readLine()) != null){
			if(temp.contains("%%")){
				entryTable.add((byte) super.getFilePointer());
			}
		}
		return entryTable;
	}
	
	/**
	 * Show the entry in a byte format at random
	 * @param entryTable
	 */
	public void showEntryAtRandom(List<Byte> entryTable){
		int max = entryTable.size();
		Random ran = new Random();
		System.out.println("The one of entry positions is " + entryTable.get(ran.nextInt(max)) + " byte from the beginning.");
	}
	
	public static void main(String[] args) throws IOException {
		EntryTableMaker etm = new EntryTableMaker("test2008.txt", "r");
		etm.showEntryAtRandom(etm.readEntry("test2008.txt"));
	}

}
