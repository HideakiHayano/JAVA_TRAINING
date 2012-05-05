package JPL.ch6.ex6_4;

public enum ColorOfTrafficLight {
	
	RED, 
	GREEN,
	YELLOW;
	
	Color getColor(){		
		if(this.equals(RED)){
			return new Color(255, 0, 0);
		}
		else if(this.equals(GREEN)){
			return new Color(255, 0, 255);
		}
		else if(this.equals(YELLOW)){
			return new Color(255, 255, 0);
		}
		return null;
	}
	
	class Color{
		
		private int Red;
		private int Green;
		private int Blue;
		
		Color(int Red, int Green, int Blue){
			this.Red = Red;
			this.Green = Green;
			this.Blue = Blue;
		}
		
		public String toString(){
			String desc = "Red:"+ Red + "," + "Green:"+ Green + "," + "Blue:"+ Blue;
			return desc;	
		}
	}
	
	public static void main(String[] args){
		System.out.println(ColorOfTrafficLight.RED.getColor().toString());
		System.out.println(ColorOfTrafficLight.GREEN.getColor().toString());
		System.out.println(ColorOfTrafficLight.YELLOW.getColor().toString());
	}
	
}
