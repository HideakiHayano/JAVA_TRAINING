package ch24.ex24_01;

import java.util.ResourceBundle;

public class GlobalHello {

	public static void main(String[] args) {
		//Fail
		ResourceBundle res = ResourceBundle.getBundle("GlobalRes");
		String msg;
		if(args.length > 0){
			msg = res.getString(GlobalRes.GOODBYE);
		}
		else{
			msg = res.getString(GlobalRes.HELLO);
		}
		System.out.println(msg);
		
		//Fail
		ResourceBundle res1 = ResourceBundle.getBundle("GlobalRes_en");
		String msg1;
		if(args.length > 0){
			msg1 = res1.getString(GlobalRes.GOODBYE);
		}
		else{
			msg1 = res1.getString(GlobalRes.HELLO);
		}
		System.out.println(msg1);
		
		//Fail. The class "GlobalRes_en_AU" does not exist, so GlobalRes_en_AU.properties will be read.
		ResourceBundle res2 = ResourceBundle.getBundle("GlobalRes_en_AU");
		String msg2;
		if(args.length > 0){
			msg2 = res2.getString(GlobalRes.GOODBYE);
		}
		else{
			msg2 = res2.getString(GlobalRes.HELLO);
		}
		System.out.println(msg2);
	}

}
