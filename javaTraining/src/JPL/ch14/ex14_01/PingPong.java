package JPL.ch14.ex14_01;

public class PingPong implements Runnable{
	
	private String word;
	private int delay;
	
	public PingPong(String whatToSay, int delayTime){
		word= whatToSay;
		delay = delayTime;
	}
	
	public PingPong(String word){
		this.word= word;
	}
	
	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println(word + " ");
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Runnable ping = new PingPong("ping", 33);
		Runnable pong = new PingPong("Pong", 100);
		Thread thread1 = new Thread(ping, "Tiger");
		Thread thread2 = new Thread(pong, "Dragon");
		
		System.out.println("thread1�̖��O�F" + thread1.getName());
		System.out.println("thread2�̖��O�F" + thread2.getName());
		
		thread1.start();
		thread2.start();
	}

}
