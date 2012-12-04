package ch17.ex17_05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

//Modified: getResource(), shutDown()
public final class ResourceManager {
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
	
	@SuppressWarnings("unchecked")
	public synchronized Resource getResource(Object key){//How can I get the referent from the key? I'd like to check if the specified referent has been enqueued.
		if(shutdown)
			throw new IllegalStateException();
		
		boolean keyAvailable = true;
		
		while(true){
			PhantomReference<Object> ref;
			Resource res = null;
			if((ref = (PhantomReference<Object>) queue.poll()) != null){
				res = refs.get(ref);//"ref" is no longer available.
				refs.remove(ref);
				if(res != null){
					keyAvailable = false;
					res.release();
				}
					ref.clear();//Then, "key" referred to by "ref" is retrieved.
			}
			else//There is no key to be retrieved.
				break;
		}
		if(keyAvailable){
			Resource res = new ResourceImpl(key);
			Reference<?> ref = new PhantomReference<Object>(key, queue);//It is possible to get the object by way of "ref" from the key.
			refs.put(ref, res);
			return res;
		}
		//key is not available
		return null;
	}
	
	static class ResourceImpl implements Resource{
		
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
