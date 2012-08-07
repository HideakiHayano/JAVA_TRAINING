package JPL.ch14.ex14_8;

public class Friendly{
	
	private Friendly partner;
	private String name;
	private static long num;
	private long lockOrder;
	
	//オブジェクト生成時にロックの取得順番を定義しクラス変数で管理する。複数のスレッドから同時に
	//クラス変数にアクセスされると困るので排他制御する。
	public Friendly(String name){
		this.name = name;
		synchronized(Friendly.class){
			lockOrder = num++;
		}
	}
	
	public void hug(){
		Friendly former;
		Friendly latter;
		
		if(this.lockOrder > this.partner.lockOrder){
			former = this;
			latter = this.partner;
		}
		else{
			former = this.partner;
			latter = this;
		}
		
		synchronized(former){
			synchronized(latter){
				System.out.println(Thread.currentThread().getName() + "in" + 
			    name + "hug() trying to invoke" + partner.name + ".hugBack()");
				partner.hugBack();
			}
		}
	}
	
	private void hugBack(){
		Friendly former;
		Friendly latter;
		
		if(this.lockOrder > this.partner.lockOrder){
			former = this;
			latter = this.partner;
		}
		else{
			former = this.partner;
			latter = this;
		}
		
		synchronized(former){
			synchronized(latter){
				System.out.println(Thread.currentThread().getName() + "in" + name +
			    "hugBack()");
			}
		}
	}
	
	public void becomeFriend(Friendly partner){
		this.partner = partner;
	}
	
	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");
		
		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);
		MyThread myThread1 = new MyThread(jareth); 
		MyThread myThread2 = new MyThread(cory);
		
		myThread1.start();
		myThread2.start();
	}

}
