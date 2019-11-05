package lab4;

import java.util.Calendar;
import java.util.Date;

/*
 * Now make a little program that uses your Julian Date class.
 *  The program should ask for a birthday and figure out 
 *  how many days old the person is and what weekday they were born on. 
 *  If today is their birthday, then write out a special message. 
 *  If you have lived a number of days that is divisible by 100, 
 *  print a special message! Check your program using both of your birthdays.
 *   Which of you is the oldest? Is there a Sunday's Child?
 */
public class Birthday extends myJulianDate{
	static final String[] weekday= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	
	public Birthday(int y,int m, int d) {
		super();
	    int daysOld = gregToJD(y,m,d);
	    System.out.println("You are "+daysOld+" days old.");//2448571
	    System.out.println("And you are "+bornOnWhichDay(daysOld)+"'s child.");
	    int yearOld=todayIsBday(y,m,d);
	    if(yearOld!=0) {
	    	System.out.println("Today is your "+yearOld+"th birthday!");
		    
	    }
	    hundred(daysOld);
	}
	public static void main(String args[]) {
		Birthday b=new Birthday(1991,8,31);
		
	}
	
	//weekday, sunday's child?
	public String bornOnWhichDay(int JDdays) {
		int diff=JDdays-gregToJD(1900,1,1);//mon
		 
		return weekday[diff%7];
	}
	//today
	public int todayIsBday(int y,int m,int d) {
		Date date=new Date(); // your date
		// Choose time zone in which you want to interpret your Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"."+month+"."+day);
		if(m==month && d==day) {
			return year-y;
		}
		return 0;
	}
	//divisible by 100?
	public void hundred(int d) {
		if(d%100==0) {
			System.out.println("You have lived "+d/100+" of 100 days.");
		}
	
	}
}
