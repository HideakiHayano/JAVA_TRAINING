package ch03.ex03_09;

public class Garage implements Cloneable{
	
	private Vehicle[] vehicleList;
	private int top; 
	
	public Garage(int numOfElements){
		vehicleList = new Vehicle[numOfElements];
		top = 0;
	}
	
	public void push(Vehicle vehicle){
		this.vehicleList[top++] = vehicle;
	}
	
	public void pop(){
		this.vehicleList[top--] = null;
	}
	
	public Garage clone(){
		try {
			Garage newGarage = (Garage)super.clone();
			newGarage.vehicleList = this.vehicleList.clone();
			return newGarage;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * @param args
	 */
	//clone�̓R�s�[���Ɠ����l�����ʂ̃��X�g�����B�R�s�[���̕ύX�̓R�s�[��ɉe�����Ȃ��B
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		Vehicle vehicle3 = new Vehicle();
		
		Garage garage = new Garage(3);
		garage.push(vehicle1);
		garage.push(vehicle2);
		garage.push(vehicle3);
		
		Garage test = garage.clone();
		
		for(int i = 0; i < garage.vehicleList.length; i++){
			System.out.println(garage.vehicleList[i].equals(test.vehicleList[i]));
			System.out.println(garage.vehicleList[i] == test.vehicleList[i]);
		}
		System.out.println("-----------------------------");
		
		System.out.println(garage == test);
		System.out.println(garage.equals(test));
		
		System.out.println("-----------------------------");
		
		Garage garage2 = new Garage(3);
		garage2.push(vehicle1);
		garage2.push(vehicle2);
		
		Garage test2 = garage2.clone();
		
		garage2.push(vehicle3);

		for(int i = 0; i < garage2.vehicleList.length; i++){
			System.out.println(garage2.vehicleList[i].equals(test2.vehicleList[i]));
			System.out.println(garage2.vehicleList[i] == test2.vehicleList[i]);
		}
		
		System.out.println(garage2.vehicleList[2]);
		System.out.println(test2.vehicleList[2]);
		
	}

}
