package ch05.ex05_02;

public class BankAccount {
	private long number;
	private long balance;
	private Action lastAct;
	private History history;
	
	public BankAccount(long number, long balance){
		this.number = number;
		this.balance = balance;
		history = new History();
	}
	
	public class Action{
		private String act;
		private long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		
		public String toString(){
			return number + ": " + act + " " + amount;
		}
	}
	
	public class History{
		private final int historySize = 10;
		private Action[] history;
		private int refIndex = 0;
		private int setIndex = 0;
		
		public History(){
			history = new Action[historySize];
		}
		
		public Action next(){
			if(refIndex <= historySize-1){
				return history[refIndex++];
			}
			else
				return null;
		} 
		
		public void add(Action action){
			if(setIndex < historySize){
				history[setIndex++] = action;
		    }
			else{
				for(int i=0; i<historySize-1; i++){
					history[i] = history[i+1];
				}
				history[historySize-1] = action;
			}
			
		}
		
		public void clear(){
			refIndex = 0;
		}
		
	}
	
	public History history(){
		return history;
	}
	
	public void deposit(long amount){
		balance += amount;
		lastAct = new Action("deposit", amount);
		history.add(lastAct);
	} 
	
	public void withdraw(long amount){
		balance -= amount;
		lastAct = new Action("withdraw", amount);
		history.add(lastAct);
	} 
	
	public static void main(String[] args){
		BankAccount account = new BankAccount(1111111111, 1000000);
		
		for(int i=0; i<7; i++){
			account.deposit(50000);
		}
		for(int i=0; i<7; i++){
			account.withdraw(30000);
		}
		for(int i=0; i<10; i++){
			System.out.println(account.history().history[i]);
		}
	}
}
