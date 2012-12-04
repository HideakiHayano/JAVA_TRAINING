package ch17.ex17_03;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import ch17.ex17_04.Resource;

//Add resourceMap　in order to link the key to the resource when it is created.
//Refer to the constructor of ResourceImpl as well.
public final class ResourceManager {
	
	private static Map<Object, Object> resourceMap = new HashMap<Object, Object>();
	
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
	
	private class ResourceImpl implements Resource{
		//Completely wrong. Use SoftRefernce or WeakRefernce to manage the key.
		
		boolean needsRelease = false;
		
		ResourceImpl(Object key){
			resourceMap.put(key, this);
			
			//settings of outer resources
			
			needsRelease = true;
		}
		
		public void use(Object key, Object... args) {
			if(resourceMap.containsKey(key))
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