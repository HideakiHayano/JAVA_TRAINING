package ch02.ex02_08;

public class LinkedList {
	public int numOfElements;
	public Object[] object;
	public static int id = 0;
	
	//���X�g�Ɋi�[���鐔�����߂�R���X�g���N�^
	public LinkedList(int numOfElements){
		this.numOfElements =numOfElements;
		object = new Object[numOfElements];
	} 
}
