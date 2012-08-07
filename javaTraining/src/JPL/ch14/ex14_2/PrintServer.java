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
			System.out.println("�A�N�Z�X�ᔽ");
		}
	}
	
	public static void main(String[] args) {
		Runnable ps1 = new PrintServer();//�����ȃA�N�Z�X�B�R���X�g���N�^�Ő������ꂽ�X���b�h�ɂ��run()�̎��s�B
		Runnable ps2 = new PrintServer();//�����ȃA�N�Z�X�B�R���X�g���N�^�Ő������ꂽ�X���b�h�ɂ��run()�̎��s�B
		Thread thread1 = new Thread(ps1, "Tiger");
		Thread thread2 = new Thread(ps2, "Dragon");
		thread1.start();//�A�N�Z�X�ᔽ
		thread2.start();//�A�N�Z�X�ᔽ
	}

}
