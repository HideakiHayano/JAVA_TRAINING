package JPL.ch3.ex3_7;

public class ScreenColor {
	
	private String color = "Black";
	
	//value���P�x�Ƃ��āA�F�����肷��
	public ScreenColor(Object value){
		if(Integer.parseInt(value.toString()) >= 0 && Integer.parseInt(value.toString()) < 20){
			this.color = "Black";	
		}
		else if (Integer.parseInt(value.toString()) >= 20 && Integer.parseInt(value.toString()) <= 255){
			this.color = "White";
		}
		else
			System.out.println("0����255�܂ł̐��l�������͂ł��܂���");
	}
	
	public String getScreenColor(){
		return color;
	}

}
