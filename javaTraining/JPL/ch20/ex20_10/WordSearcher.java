package ch20.ex20_10;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class WordSearcher {
	
	private HashMap<String, Integer> hash = new HashMap<String, Integer>();
	
	/**
	 * Count the number of specified words in the file.
	 * @param fileName
	 * @param word
	 * @return hash
	 * @throws IOException 
	 */
	public HashMap count(String fileName, String word) throws IOException{
		hash.put(word, null);
		FileReader fr = new FileReader(fileName);
		StreamTokenizer in = new StreamTokenizer(fr);
		int count = 0;
		while(in.nextToken() != StreamTokenizer.TT_EOF){
			if(in.ttype == StreamTokenizer.TT_WORD){
				if(in.sval.equals(word)){
					count++;
				}
			}
		}
		hash.put(word, count);

		return hash;	
	}
	/**
	 * Show all keys and values contained in the hash.
	 * @param hash
	 */
	public void showContents(HashMap hash){
		//Get all keys and Objects contained in hash.
		Set entrySet = hash.entrySet();
		Iterator it = entrySet.iterator();
		String key = null;
		Object value = null;
		while(it.hasNext()){
			Map.Entry entry = (Entry) it.next();
			key = (String) entry.getKey();
			value = (Object) entry.getValue();
		}
		System.out.println("The number of "  + key + " is " + value + ".");
	}
	
	public static void main(String[] args) throws IOException {
		WordSearcher searcher = new WordSearcher();
		HashMap hash = searcher.count("test2010.txt", "apple");
		searcher.showContents(hash);
	}

}
