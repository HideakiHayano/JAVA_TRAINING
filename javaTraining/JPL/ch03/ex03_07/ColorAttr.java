package ch03.ex03_07;

public class ColorAttr extends Attr{
	private ScreenColor myColor;
	
	///////////////////////////////////////////
	//ex3_7
	//���[���Fequals()���\�b�h��hashCode()���\�b�h�́A
	//2�̃I�u�W�F�N�g��equals()���\�b�h�œ������Ɣ��肳�ꂽ�ꍇ�A���҂̃n�b�V���R�[�h�͓������Ȃ���΂Ȃ�Ȃ�
	//��œn���ꂽ�I�u�W�F�N�g��ColorAttr�^�ł���A���O����������Γ���̂��̂Ƃ݂Ȃ��B
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
