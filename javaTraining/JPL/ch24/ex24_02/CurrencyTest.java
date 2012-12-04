package ch24.ex24_02;

import java.util.Currency;
import java.util.Locale;

public class CurrencyTest {
	private static Locale[] localeList = {Locale.CANADA, Locale.KOREA, 
			Locale.FRANCE, Locale.JAPAN, Locale.ITALY, Locale.UK};
	
	public static void main(String[] args) {
		Currency cur;
		for(int i = 0; i < localeList.length; i++){
			System.out.println("Currency at " + localeList[i] + " is symbolized at each Local as below.");
			cur =  Currency.getInstance(localeList[i]);
			for(int j = 0; j < localeList.length; j++){
				System.out.println(" " + localeList[j] + ": " + cur.getSymbol(localeList[j]));
			}
		}
	}

}
