package JPL.ch1.ex1_15;

public interface ModifiedLookup extends Lookup{
	
	void add(int index, String name, Object value);
	void remove(int index);
	
}
