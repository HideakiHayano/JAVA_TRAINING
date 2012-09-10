package JPL.ch14.ex14_03;

public class Number extends Thread{

	int value;
	synchronized void add(int value){
			this.value += value;
			System.out.println("added value: " + value + " result value: " + this.value);
	}

	public static void main(String[] args) {
		Number num = new Number();
		
		MyThread1 myThread1 = new MyThread1(num);
		MyThread2 myThread2 = new MyThread2(num);
		
		myThread1.start();
		myThread2.start();
	}
}
