package JPL.ch14.ex14_3;

public class MyThread1 extends Thread{
	Number num;
	
	MyThread1(Number num){
		this.num = num;
	}
	
	public void run(){
		for(int i = 0; i < 5; i++){
			num.add(1000);
		}
	}
}
