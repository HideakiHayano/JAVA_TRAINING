package JPL.ch2.ex2_10;

public class Vehicle {
	public double speed;
	public double angle;
	public String ownerName;
	public int id;
	
	public static int nextID = 1;
	
	public Vehicle(){
		speed = 0.0;
		angle = 0.0;
		ownerName = "";
		id = nextID;
		nextID++;
	}
	
	public Vehicle(String ownerName){
		speed = 0.0;
		angle = 0.0;
		this.ownerName = ownerName;
		id = nextID;
		nextID++;
	}
	
	public static int getMAXID(){
		return nextID-1;
	}
	
	public String toString(){
		String desc = ownerName + "の" +"Vehicle" + id + "は"
				+ angle + "方向に" + "時速" + speed + "kmで走っています";
		return desc;
	}
}
