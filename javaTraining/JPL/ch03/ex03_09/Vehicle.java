package ch03.ex03_09;

public class Vehicle implements Cloneable{

	/**
	 * @param args
	 */
	
	public static final String TURN_LEFT = "TURNLEFT";
	public static final String TURN_RIGHT = "TURNRIGHT";
	
	protected double speed;
	protected double angle;
	protected String ownerName;
	protected int id;
	
	protected static int nextID = 1;
	
	///////////////////////////////////////////////////
	//ex3_8
	public Vehicle clone(){
		try {
			return (Vehicle)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	///////////////////////////////////////////////////
	
	public Vehicle(){
		speed = 0.0;
		angle = 0.0;
		ownerName = "����";
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
	
	//ex2_17�ǉ�
	public void turn(double angle){
		
		this.angle = angle;
		
	}
	
	public void turn(double angle, String direction){
		//���v�܂��𐳂Ƃ���
		if(direction.equals(TURN_LEFT)){
			
			this.angle += angle;
			
		}
		else if(direction.equals(TURN_RIGHT)){
			
			this.angle -= angle;
			
		}
		
	}
	//
	
	//ex2_15�ǉ�
	public void changeSpeed(double speed){
		
		this.speed = speed;
	}
	
	public void stop(){
		
		this.speed = 0.0;
		
	}
	
	//
	
	public double getSpeed(){
		return speed;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public double getAngle(){
		return angle;
	}
	
	public void setAngle(double angle){
		this.angle = angle;
	}
	
	public String getOwnerName(){
		return ownerName;
	}
	
	public void setOwnerName(String ownerName){
		this.ownerName = ownerName;
	}
	
	public int getID(){
		return id;
	}
	
	public static int getMAXID(){
		return nextID-1;
	}
	
	
	
	public String toString(){
		String desc = ownerName + "��" +"Vehicle" + id + "��"
				+ angle + "����" + "����" + speed + "km�ő����Ă��܂�";
		return desc;
	}

}
