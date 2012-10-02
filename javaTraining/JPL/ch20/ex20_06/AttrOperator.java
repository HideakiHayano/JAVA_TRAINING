package ch20.ex20_06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class AttrOperator {
	
	private Map<String, Double> attrs;
	
	public AttrOperator(Map attrs){
		this.attrs = attrs;
	}
	
	public Map getAttrs(){
		return attrs;
	}
	/**
	 * Operate attributes following the designated reader.
	 * @param reader
	 * @throws IOException
	 */
	public void operate(Reader reader) throws IOException{
		StreamTokenizer in = new StreamTokenizer(reader);
		char c = 0;
		String key = null;
		while(in.nextToken() != StreamTokenizer.TT_EOL){
			if(in.ttype == StreamTokenizer.TT_WORD){
				key = in.sval;
			}
			else if(in.ttype == '=' || in.ttype == '+' || in.ttype == '-'){
				c = (char) in.ttype;
			}
			else if(in.ttype == StreamTokenizer.TT_NUMBER){
				if(c == '='){
					attrs.put(key, in.nval);
				}
				else if(c == '+'){
					if(attrs.containsKey(key)){
						attrs.put(key, attrs.get(key) + in.nval);
					}
					else{
						attrs.put(key, 0 + in.nval);
					}
				}
				else if(c == '-'){
					if(attrs.containsKey(key)){
						System.out.println("key" + key);
						attrs.put(key, attrs.get(key) - in.nval);
					}
					else{
						attrs.put(key, 0 - in.nval);
					}
				}
			}
			else{
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("test2006.txt");
		Map attr = new HashMap();
		AttrOperator ao = new AttrOperator(attr);
		ao.operate(fr);
		System.out.println("power: " + ao.getAttrs().get("power"));
		System.out.println("control: " + ao.getAttrs().get("control"));
		System.out.println("spin: " + ao.getAttrs().get("spin"));
		fr.close();
	}

}
