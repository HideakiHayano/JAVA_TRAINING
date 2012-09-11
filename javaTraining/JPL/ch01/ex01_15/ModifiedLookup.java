package ch01.ex01_15;

public interface ModifiedLookup extends Lookup{
	
	void add(int index, String name, Object value);
	void remove(int index);
	
}
