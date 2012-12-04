package ch17.ex17_05;

import java.lang.ref.PhantomReference;

import junit.framework.TestCase;

public class ResourceManagerTest extends TestCase{
	
	public void testRun(){
		ResourceManager resourceManager = new ResourceManager();
		String key = "key";
		Resource res = null;
		PhantomReference<Object> ref = new PhantomReference<Object>(key, resourceManager.queue);
		resourceManager.refs.put(ref, res);
		ref.enqueue();
		System.out.println(resourceManager.getResource(key));;
		
		//Fail. The key hasn't been retrieved though it should be. 
		assertEquals(resourceManager.getResource(key), null);
	}
}
