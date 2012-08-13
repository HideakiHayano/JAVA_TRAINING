package JPL.ch14.ex14_9;

public class MyThreadGroup extends Thread{
	
	public void enumerateThreads(ThreadGroup threads){
		//スレッドグループ内のスレッド数分だけ配列の要素を確保
		Thread[] list = new Thread[threads.activeCount()];
		//listにthreads内のスレッドを格納。階層内のスレッドを全て含むため、recurse = true;
		threads.enumerate(list, true);
		if(threads.activeCount() != 0){
			for(int i = 0; i < list.length; i++){
				System.out.println("threads[i]:" + list[i].getName());
			}
		}
		else{
			System.out.println("activeCount()=0");
		}
	}
	
	public void run() {
		for(int i = 0; i < 100; i++){
			if(i == 1){
				Thread th1 = new Thread(currentThread().getThreadGroup(), "t1");
			}
			else if(i == 2){
				Thread th2 = new Thread(currentThread().getThreadGroup(), "t2");
			}
			else if(i == 3){
				Thread th3 = new Thread(currentThread().getThreadGroup(), "t3");
			}
			enumerateThreads(currentThread().getThreadGroup());
			
		}
	}
	
	public static void main(String[] args) {
		MyThreadGroup mtg = new MyThreadGroup();
		mtg.start();
	}

}
