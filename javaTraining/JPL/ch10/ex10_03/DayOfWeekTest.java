package ch10.ex10_03;

public class DayOfWeekTest {
	
	public enum DayOfWeek {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	}
	
	public static boolean isWorkingDay(DayOfWeek day){
		switch(day){
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			return true;
		case SUNDAY:
		case SATURDAY:	
			return false;
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		System.out.println(isWorkingDay(DayOfWeek.SUNDAY));
		System.out.println(isWorkingDay(DayOfWeek.MONDAY));
	}

}
