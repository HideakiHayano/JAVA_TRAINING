package JPL.ch14.ex14_2;

import JPL.ch14.ex14_1.PingPong;

public class PrintServer implements Runnable{
	Thread thread = new Thread();
	public PrintServer(){
		this.thread = new Thread(this);
		thread.start();
	}

	public void run(){
		if(Thread.currentThread().equals(thread)){
			System.out.println("run()");
		}
		else{
			System.out.println("アクセス違反");
		}
	}
	
	public static void main(String[] args) {
		Runnable ps1 = new PrintServer();//正当なアクセス。コンストラクタで生成されたスレッドによるrun()の実行。
		Runnable ps2 = new PrintServer();//正当なアクセス。コンストラクタで生成されたスレッドによるrun()の実行。
		Thread thread1 = new Thread(ps1, "Tiger");
		Thread thread2 = new Thread(ps2, "Dragon");
		thread1.start();//アクセス違反
		thread2.start();//アクセス違反
	}

}
