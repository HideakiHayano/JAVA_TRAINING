package JPL.ch1.ex1_8;

public class Point {
	
	public double x, y;
	
	public void clear(){
		this.x = 0.0;
		this.y = 0.0;
	}
		
	public void move(double x,double y){
		this.x = x;
		this.y = y;
	}		
	
	public void move(Point point){
		this.x = point.x;
		this.y = point.y;
	}
			
}
