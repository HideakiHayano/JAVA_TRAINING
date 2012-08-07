package JPL.ch14.ex14_6;

public class Message extends Thread{
	
	boolean condition = false;
	
	public synchronized void showMessage(){
		System.out.println("メッセージ");
	}
	
	public void run(){
		for(;;){
			showMessage();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
