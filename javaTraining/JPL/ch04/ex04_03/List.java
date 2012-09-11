package ch04.ex04_03;

public interface List {
	void add(int n, Object obj);
	void remove(int n);
	Node getContent(int n);
	int getListSize();
}
