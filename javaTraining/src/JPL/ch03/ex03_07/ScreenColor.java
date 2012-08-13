package JPL.ch3.ex3_7;

public class ScreenColor {
	
	private String color = "Black";
	
	//valueを輝度として、色を決定する
	public ScreenColor(Object value){
		if(Integer.parseInt(value.toString()) >= 0 && Integer.parseInt(value.toString()) < 20){
			this.color = "Black";	
		}
		else if (Integer.parseInt(value.toString()) >= 20 && Integer.parseInt(value.toString()) <= 255){
			this.color = "White";
		}
		else
			System.out.println("0から255までの数値しか入力できません");
	}
	
	public String getScreenColor(){
		return color;
	}

}
