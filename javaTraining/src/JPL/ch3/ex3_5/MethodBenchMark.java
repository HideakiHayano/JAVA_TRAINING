package JPL.ch3.ex3_5;

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
	//loop‚É‚©‚©‚éŽžŠÔ‚ðŒv‘ª
	public long calculateLoopTime(int count){
		long start = System.nanoTime();
		for(int i = 0; i < count; i++){

		}
		return (System.nanoTime() - start);
	}
}
