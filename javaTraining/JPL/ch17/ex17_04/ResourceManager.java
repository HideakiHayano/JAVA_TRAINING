package ch17.ex17_04;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {
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
					ref = queue.remove();
					res = null;
					synchronized(ResourceManager.this){
						res = refs.get(ref);
						refs.remove(ref);
					}
				}catch(InterruptedException ex){
					break;
				}
				finally{
					while(true){
						try {
							ref = queue.remove();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						res = null;
						synchronized(ResourceManager.this){
							res = refs.get(ref);
							refs.remove(ref);
						}
						if(refs.isEmpty()){
							break;
						}
					}
				}
			}
			
		}
	}
}
