package ch14.ex14_09;

public class MyThreadGroup extends Thread{
	
	public void enumerateThreads(ThreadGroup threads){
		//�X���b�h�O���[�v���̃X���b�h���������z��̗v�f���m��
		Thread[] list = new Thread[threads.activeCount()];
		//list��threads���̃X���b�h���i�[�B�K�w���̃X���b�h��S�Ċ܂ނ��߁Arecurse = true;
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
