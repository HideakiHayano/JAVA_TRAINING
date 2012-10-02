package ch21.ex21_04;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * This class cannot extend class "ShortStrings" because it is not allowed to implement
 * interface "Iterator" multiple times.
 * @author hayano
 *
 */
public class NewShortStrings implements ListIterator<String>{
	private ListIterator<String> strings;//original strings
	private int index;
	private int nextIndex;
	private int previousIndex;
	private String nextShort;
	private String previousShort;
	private boolean nextCalled = false;
	private boolean previousCalled = false;
	private final int maxLen;//Return strings whose length are smaller than maxLen.
	
	public NewShortStrings(ListIterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
	}

	public static void main(String[] args) {

	}

	public boolean hasPrevious() {
		if(previousShort != null)//Already found. This is prevention for possible inappropriate call. 
			return true;
		while(strings.hasNext()){
			previousShort = strings.previous();
			index--;
			if(previousShort.length() <= maxLen)
				previousIndex = index;
				return true;
		}
		previousShort = null;//Not found.
		return false;
	}

	public int nextIndex() {
		return nextIndex;
	}

	public int previousIndex() {
		return previousIndex;
	}

	public String previous() {
		if(previousShort == null && !hasPrevious())
			System.out.println("No Such Element");
		String n = previousShort; //memorize previousShort
		previousShort = null;
		nextCalled = false;
		previousCalled = true;
		return n;
	}

	public void set(String o) {
		if(nextCalled && o.length() <= maxLen){
			nextShort = o;
		}
		else if(previousCalled && o.length() <= maxLen){
			previousShort = o;
		}
		else{
			System.out.println("Failed to set.");
		}
	}

	public void add(String o) {
		
//		temp = nextShort;//preserve
//		if(o.length() <= maxLen){
//			nextShort = o;
//			index++;
//			strings.
//		}
	}
	
	public String next(){
		if(nextShort == null && !hasNext())
			System.out.println("No Such Element");
		String n = nextShort; //memorize nextShort
		nextShort = null;
		nextCalled = true;
		previousCalled = false;
		return n;
	}

	public boolean hasNext() {
		if(nextShort != null)//Already found. This is prevention for possible inappropriate call. 
			return true;
		while(strings.hasNext()){
			nextShort = strings.next();
			index++;
			if(nextShort.length() <= maxLen)
				nextIndex = index;
				return true;
		}
		nextShort = null;//Not found.
		return false;
	}

	public void remove() {
		if(nextCalled){
			nextShort = null;
		}
		else if(previousCalled){
			previousShort = null;
		}
		else{
			System.out.println("Failed to remove.");
		}
	}


}
