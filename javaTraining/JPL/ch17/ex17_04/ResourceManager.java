package ch17.ex17_04;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {
	//note
	//Releasing all resources means that the object of Map refs is empty. 
	//Note that you cannot judge it from the RefernceQueue.
	
	//Release all resources in the "finally" block even if this thread is interrupted. 
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;
	
	public ResourceManager(){
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		reaper = new ReaperThread();
		reaper.start();
		
		//initialization of resource
	}
	
	public synchronized void shutdown(){
		if(!shutdown)
			shutdown = true;
		reaper.interrupt();
	}
	
	public synchronized Resource getResource(Object key){
		if(shutdown)
			throw new IllegalStateException();
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		ref.enqueue();//for test
		refs.put(ref, res);
		return res;
	}
	
	private static class ResourceImpl implements Resource{
		
		int keyHash;
		boolean needsRelease = false;
		
		ResourceImpl(Object key){
			keyHash = System.identityHashCode(key);
			
			//settings of outer resources
			
			needsRelease = true;
		}
		
		public void use(Object key, Object... args) {
			if(System.identityHashCode(key) != keyHash)
				throw new IllegalArgumentException("wrong key");
			
			//use resources
		}
		
		public synchronized void release() {
			if(needsRelease)
				needsRelease = false;
			
			//release resources 
		}

	}
	
	class ReaperThread extends Thread{
		Reference<?> ref; 
		Resource res;

		public void run(){
			//Run until interrupted.
			while(true){
				try{
					System.out.println("processing");
					ref = queue.remove();//ref:reference to a key
					res = null;
					synchronized(ResourceManager.this){
						res = refs.get(ref);//res:an object mapping by the key of "ref"
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				}catch(InterruptedException ex){//Only in the case of waiting in the middle of "remove()".
					ex.printStackTrace();
					System.out.println("interrupted");
					//do nothing
				}
				finally{
					if(shutdown){
						while(true){
							if(queue.poll() != null){//Without this, this thread may stop in the process of "remove()".
								try {
									ref = queue.remove();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}//ref:reference to a key
								res = null;
								synchronized(ResourceManager.this){
									res = refs.get(ref);//res:an object mapping by the key of "ref"
									refs.remove(ref);
								}
								res.release();
								ref.clear();
							}
							else{
								System.out.println("break");
								break;
							}
						}
						System.out.println("break");
						break;
					}
				}
			}
			System.out.println("end");	
		}
	}
}
