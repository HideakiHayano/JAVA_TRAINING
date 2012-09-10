package JPL.ch16.ex16_05;

import JPL.ch16.ex16_04.BugsFixed;

@BugsFixed(bugIDs = { "aa" }, fixedBy = { "Roger" }, value = { "b" })
public enum ColorOfTrafficLight {
	RED{
		@Override
		public Color getColor(){
			return getRedColor();
		}
	},
	GREEN{
		public Color getColor(){
			return getGreenColor();
		}
	},
	YELLOW{
		public Color getColor(){
			return getYellowColor();
		}
	};
	
	public abstract Color getColor();
	
	Color getRedColor(){
		return new Color(255, 0, 0);
	}
	
	Color getGreenColor(){
		return new Color(255, 0, 255);
	}
	
	Color getYellowColor(){
		return new Color(255, 255, 0);
	}
	
	class Color{
		private final int bitPerPixel = 24;//bit
		private final int numOfColorComponents = 3; 
		
		private int Red;
		private int Green;
		private int Blue;
		
		Color(int Red, int Green, int Blue){
			
			if(checkValue(Red, Green, Blue)){
				this.Red = Red;
				this.Green = Green;
				this.Blue = Blue;			
			}
		}
		
		public String toString(){
			String desc = "Red:"+ Red + "," + "Green:"+ Green + "," + "Blue:"+ Blue;
			return desc;	
		}
		
		boolean checkValue(int Red, int Green, int Blue){
			int maxValue = 1;
			
			for(int i = 0; i < bitPerPixel/numOfColorComponents; i++){
				int temp = 2;
				maxValue = maxValue*temp;
			}
			
			maxValue = maxValue - 1 ;
			
			if(Red < 0 || Green < 0 || Blue < 0){
				System.out.println("エラー:RGB値に負の値は使えない");
				return false;
			}
			if(Red > maxValue || Green > maxValue || Blue > maxValue){
				System.out.println("エラー：" + bitPerPixel +"bppなのでRGB値の最大値は" + maxValue);
				return false;
			}
			return true;
		}
	}
	
	public static void main(String[] args){
		System.out.println("RED " + ColorOfTrafficLight.RED.getColor().toString());
		System.out.println("GREEN " + ColorOfTrafficLight.GREEN.getColor().toString());
		System.out.println("YELLOW " + ColorOfTrafficLight.YELLOW.getColor().toString());
	}
	
}
