package JPL.ch14.ex14_4;

public class MyThread2 extends Thread{
	Number num;
	
	MyThread2(Number num){
		this.num = num;
	}
	
	public void run(){
		for(int i = 0; i < 5; i++){
			num.addIDNum(5);
		}
	}
}
