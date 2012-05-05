package JPL.ch3.ex3_7;

public class ColorAttr extends Attr{
	private ScreenColor myColor;
	
	///////////////////////////////////////////
	//ex3_7
	//ルール：equals()メソッドとhashCode()メソッドは、
	//2つのオブジェクトがequals()メソッドで等しいと判定された場合、両者のハッシュコードは等しくなければならない
	//引数で渡されたオブジェクトがColorAttr型であり、名前が等しければ同一のものとみなす。
	public boolean equals(Object obj){
		
		if(this == obj){
			return true;
		}
		
		if(obj instanceof ColorAttr){
			if(this.getName().equals(((ColorAttr) obj).getName())){
				return true;
			}
			else
				return false;
		}
		else {
			return false;
		}
	}
	
	public int hashCode(){
		return super.getName().hashCode();
	}
	
	///////////////////////////////////////////
	
	public ColorAttr(String name, Object value){
		super(name, value);
		decodeColor();
	}
	
	public ColorAttr(String name){
		this(name, "transparent");
	}
	
	public ColorAttr(String name, ScreenColor value){
		super(name, value.toString());
		myColor = value;
	}
	
	public Object setValue(Object newValue){
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	
	public ScreenColor setValue(ScreenColor newValue){
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	public ScreenColor getColor(){
		return myColor;
	}
	
	protected void decodeColor(){
		if(getValue() == null){
			myColor = null;
		}
		else
			myColor = new ScreenColor(getValue());
	}
	
}
