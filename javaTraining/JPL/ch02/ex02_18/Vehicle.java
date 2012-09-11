package ch02.ex02_18;

public class Vehicle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("�Ԃ̏��L�҂̖��O���͂��Ă�������");
		
		for(int i=0; i<args.length; i++){
			System.out.println(args[i]);
		}
		
		Vehicle car = new Vehicle(args[0]);
		
		System.out.println("�Ԃ̏��L�҂�"+ car.ownerName + "�ł�");
		
	}
	
	public static final String TURN_LEFT = "TURNLEFT";
	public static final String TURN_RIGHT = "TURNRIGHT";
	
	private double speed;
	private double angle;
	private String ownerName;
	private int id;
	
	private static int nextID = 1;
	
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
