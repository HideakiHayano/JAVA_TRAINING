package ch03.ex03_05;

public class MethodBenchMark extends BenchMark{
	
	 public static void main(String args[]){
		 int count = Integer.parseInt(args[0]);
		 long time = new MethodBenchMark().calculateLoopTime(count);
		 System.out.println(count + "methods in " + time + " nanoseconds");
	 }

	@Override
	void benchmark() {
		// TODO Auto-generated method stub
	}
	//loop�ɂ����鎞�Ԃ��v��
	public long calculateLoopTime(int count){
		long start = System.nanoTime();
		for(int i = 0; i < count; i++){

		}
		return (System.nanoTime() - start);
	}
}
