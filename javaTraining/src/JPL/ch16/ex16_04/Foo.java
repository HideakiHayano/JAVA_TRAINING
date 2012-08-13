package JPL.ch16.ex16_4;

@BugsFixed(bugIDs ={"111", "222"}, fixedBy = { "Roger" }, value = {"444"})
public class Foo { 

	private Foo foo;
	
	public Foo getFoo(){return foo;}
	
	public static void main(String[] args) {
//		Class<Foo> cls = Foo.class;
//		BugsFixed bugsFixed = (BugsFixed) cls.getDeclaredAnnotations(BugsFixed.class);
//		String[] bugIds = bugsFixed.value();
//		for(String id : bugIds){
//			System.out.println(id);
//      }
	}
	
}
