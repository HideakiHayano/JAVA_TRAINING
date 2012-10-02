package ch21.ex21_03;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class WeakValueMap {
	private HashMap<String, WeakReference<Object>> map;
	
	public WeakValueMap(){
		this.map = new HashMap<String, WeakReference<Object>>();
	}
	
	public WeakValueMap(HashMap map){
		this.map= map;
	}
	
	public void put(String key, Object object){
		WeakReference<Object> temp = new  WeakReference<Object>(object);
		map.put(key, temp);
	}
	
	public Object get(Object key){
		return map.get(key);	
	}
	
}
