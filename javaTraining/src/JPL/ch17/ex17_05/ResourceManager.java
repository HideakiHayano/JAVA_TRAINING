package JPL.ch17.ex17_05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

//Modified: shutdown(),getResource() 
public final class ResourceManager {
	//Release all resources in the "finally" block even if this thread is interrupted. 
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	boolean shutdown = false;
	
	public ResourceManager(){
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		
		//initialization of resource
	}
	
	public synchronized void shutdown(){
		if(!shutdown)
			shutdown = true;
		
		//Poll the queue and release all objects left in the queue.
		while(true){
			Reference<?> ref = queue.poll();
			if(ref != null){
				Resource res = refs.get(ref);//Get the resource by the reference.
				refs.remove(ref);//Remove the object referred to by "ref" because it is retrieved from the queue. 
				res.release();
				ref.clear();
			}
			else//No objects in the queue.
				break;
		}
	}
	
	@SuppressWarnings("unused")
	public synchronized Resource getResource(Object key){
		if(shutdown)
			throw new IllegalStateException();
		Resource res = new ResourceImpl(key);
		if(res == null){//The key is not available.
			res.release();
		}
		else{//The key is available. 
			Reference<?> ref = new PhantomReference<Object>(key, queue);//You'll be able to get the object by way of "ref" from the key.
			refs.put(ref, res);
		}
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
	
}
