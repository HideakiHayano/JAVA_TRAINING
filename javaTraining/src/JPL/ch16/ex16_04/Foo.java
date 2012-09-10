package JPL.ch16.ex16_04;

import java.lang.annotation.Annotation;

@BugsFixed(bugIDs ={"111", "222"}, fixedBy = { "Roger" }, value = {"444"})
public class Foo { 

	private Foo foo;
	
	public Foo getFoo(){return foo;}
	
	public static void main(String[] args) {
		Class<Foo> cls = Foo.class;
		Object[] obj = cls.getAnnotations();
		for(Object o : obj){
			System.out.println(o.toString());
		}
	}
	
}
