package ch14.ex14_06;

public class Message extends Thread{
	
	boolean condition = false;
	
	public synchronized void showMessage(){
		System.out.println("���b�Z�[�W");
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
