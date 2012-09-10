package JPL.ch16.ex16_04;

@BugsFixed(bugIDs ={"333"}, fixedBy = { "Rafa" }, value = { "333" })
public class SuperFoo extends Foo{
	
	private SuperFoo superFoo = new SuperFoo();;
	@Override
	public Foo getFoo(){return superFoo;}
	
}
