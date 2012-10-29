package ch22.ex22_12;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import ch22.ex22_04.Attr;
import ch22.ex22_04.Attributed;
import ch22.ex22_04.AttributedImpl;

public class ReadAttrTest {
	public static Attributed readAttrs(Reader source) throws IOException{
		StreamTokenizer in = new StreamTokenizer(source);
		AttributedImpl attrs = new AttributedImpl();
		Attr attr = null;
		in.commentChar('#');
		in.ordinaryChar('/');
		while(in.nextToken() != StreamTokenizer.TT_EOF){
			if(in.ttype == StreamTokenizer.TT_WORD){
				if(attr != null){
					attr.setValue(in.sval);
					attr = null;
				}else{
					attr  = new Attr(in.sval);
					attrs.add(attr);
				}
			}else if(in.ttype == '='){
				if(attr == null)
					throw new IOException("misplaced '=");
			}else{
				if(attr == null){
					throw new IOException("bad Attr name");
				}
				attr.setValue(new Double(in.nval));
				attr = null;
			}
		}
		return attrs;
	}
	
	public static Attributed readAttrs2(Reader source){
		Scanner in = new Scanner(source);
		Pattern COMMENT = Pattern.compile("#.*");
		Pattern attrPat = Pattern.compile("(.*?)=(.*)$", Pattern.MULTILINE);
		String comment;
		AttributedImpl attrs = new AttributedImpl();
		while(in.hasNext()){
			if(in.hasNext(COMMENT)){
				comment = in.findWithinHorizon(COMMENT, 0);//"|"shows the current position. #aaaa|\r\n
				in.nextLine();//"|"shows the current position. #aaaa\r\n|
			}
			else if(in.hasNext(attrPat)){
				in.findInLine(attrPat);
				MatchResult m = in.match();
				attrs.add(new Attr(m.group(1), m.group(2)));
			}
		}
		return attrs;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("old");
		FileReader fr = new FileReader("test2212.txt");
		AttributedImpl attrs = (AttributedImpl) ReadAttrTest.readAttrs(fr);
		Iterator ite = attrs.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
		System.out.println();
		System.out.println("new");
		AttributedImpl attrs2 = (AttributedImpl) ReadAttrTest.readAttrs2(fr);
		Iterator ite2 = attrs.iterator();
		while(ite2.hasNext()){
			System.out.println(ite2.next());
		}
	}

}
