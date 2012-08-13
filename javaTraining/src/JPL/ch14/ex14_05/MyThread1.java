package JPL.ch14.ex14_5;

public class MyThread1 extends Thread{
	Number num;
	
	MyThread1(Number num){
		this.num = num;
	}
	
	public void run(){
		for(int i = 0; i < 5; i++){
			num.addIDNum(3);
		}
	}
}
