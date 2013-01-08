package ch20.ex20_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Attr {

	private final String name;
	private Object value = null;
	
	public Attr(String name, Object value){
		this.name = name;
		this.value = value;
	}
	
	//argument : DataInputStream in
	//if(type instanceOf String)
	//readUTF();
	//else if(type type instanceOf Long)
	//readLong();…
	
	public Attr(InputStream is) throws IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(is);
		HashMap hash = (HashMap) in.readObject();
		//Get all keys and Objects contained in hash.
		Set entrySet = hash.entrySet();
		Iterator it = entrySet.iterator();
		String key = null;
		Object value = null;
		while(it.hasNext()){
			Map.Entry entry = (Entry) it.next();
			key = (String) entry.getKey();
			value = (Object) entry.getValue();
		}
		this.name = key;
		this.value = value;
		System.out.println("Reading the data has been completed. "  + this.name + "=" + this.value);
		in.close();
	}
	
	public String getName(){
		return name;
	}
	
	public Object getValue(){
		return value;
	}
	
	public Object setValue(Object newValue){
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public String toString(){
		return name + "='" + value + "'";
	}
	
	public void writeData(OutputStream os) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream(os);
		HashMap hash = new HashMap();
		hash.put(name, value);
		out.writeObject(hash);
		System.out.println("Writing the data has been completed. "  + this.name + "=" + this.value);
		out.close();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Attr attr = new Attr("power", 10);
		FileOutputStream fo = new FileOutputStream("test2007.txt");
		attr.writeData(fo);
		FileInputStream fi = new FileInputStream("test2007.txt");
		Attr attr2 = new Attr(fi);
	}
	
}
