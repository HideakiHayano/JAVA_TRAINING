package ch22.ex22_04;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Eye implements Observer{
	AttributedImpl watching;
	
	public Eye(AttributedImpl ai){
		this.watching = ai;
		watching.addObserver(this);
	}
	
	public void update(Observable ai, Object attrTable) {
		System.out.println("update()");
		Map<String, Attr> tmp = (Map<String, Attr>)attrTable;
		watching.attrTable = tmp;
	}
	
	public static void main(String[] args){
		AttributedImpl ai = new AttributedImpl();
		Eye eye = new Eye(ai);
		Attr attr = new Attr("number", 5);
		ai.add(attr);
		System.out.println(ai.attrTable);
		System.out.println(eye.watching.attrTable);
	}
	
}
