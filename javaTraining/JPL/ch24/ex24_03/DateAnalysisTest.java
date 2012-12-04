package ch24.ex24_03;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;

public class DateAnalysisTest {
	private static int NUM_OF_FORMAT = 4;
	private static Format[] format = new Format[NUM_OF_FORMAT];
	
	static{
		format[0] = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
		format[1] = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		format[2] = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		format[3] = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
	}
	
	public static void showDates(String text){
		Date date = null;
		try {
			date = DateFormat.getInstance().parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < NUM_OF_FORMAT; i++){
			System.out.println(format[i].format(date));
		}
	}
	
	public static void main(String[] args) {
		DateAnalysisTest.showDates("2012/11/25 22:13:13");
		DateAnalysisTest.showDates("2012/11/25 10:13:13 PM");
		DateAnalysisTest.showDates("November 25, 2012 10:13:13 PM");
	}

}
