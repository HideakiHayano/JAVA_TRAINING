package JPL.ch4.ex4_3;

public interface List {
	void add(int n, Object obj);
	void remove(int n);
	Node getContent(int n);
	int getListSize();
}
