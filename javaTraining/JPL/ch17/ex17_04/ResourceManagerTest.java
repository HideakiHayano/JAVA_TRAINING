package ch17.ex17_04;

import junit.framework.TestCase;

public class ResourceManagerTest extends TestCase{
	
	public void testRun(){
		ResourceManager resourceManager = new ResourceManager();
		String key = "key";
		resourceManager.getResource(key);
		
		resourceManager.shutdown();
		
		//Sometimes result in success .
		assertEquals(resourceManager.refs.isEmpty(), true);
	}
}
