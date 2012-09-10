package JPL.ch14.ex14_06;

public class Time extends Thread{
	
	private Message message;
	
	public Time(Message m){
		this.message = m;
		setPriority(NORM_PRIORITY+1);
	}
	
	synchronized void showElapsedTime() throws InterruptedException{
		int timeInterval = 1000;//�~���b
		int timeScale = 1000;
		long start = System.currentTimeMillis();
		long end;
		for(int i = 0; i < 10; i++){
			synchronized(message){
				//message.wait();
				wait(timeInterval);
				end = System.currentTimeMillis();
				System.out.println((int)((end - start)/timeScale) + "�b�o��");
				//message.notifyAll();
			}
		}
	}
	
	public void run(){
		try {
			synchronized(message){
				message.wait();
				showElapsedTime();
				message.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Message message = new Message();
		Time time = new Time(message);
		time.start();
		//message.start();
	}
	
}
