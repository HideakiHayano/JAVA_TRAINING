package JPL.ch14.ex14_8;

public class MyThread extends Thread{
	
	Friendly f;
	
	MyThread(Friendly f){
		this.f = f;
	}
	
	public void run(){
		f.hug();
	}
}
