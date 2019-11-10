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
	static final String[] weekday= {"Sunday","Monday","Tuesday","Wednesday",
			"Thursday","Friday","Saturday"};
	static int yearNow,monthNow, dayNow,weekdayNow;
	
	
	public Birthday(int y,int m, int d) {
		super();
		getToday();
		int bdayJD=gregToJD(y,m,d);
	    int daysOld = todayInJD()-bdayJD;
	    
	    //print today and birthday
	    System.out.println("Today is "+dateFormat(yearNow,monthNow,dayNow)
	    +", "+weekday[weekdayNow]+".");
		System.out.println("Your birthday is "+dateFormat(y,m,d)+".");
		
		
		if(daysOld>0)
		  System.out.println("You are "+daysOld+" days old.");
		else
		  System.out.println("You are due in " +Math.abs(daysOld)+" days.");
		  
		//get weekday
		String bornDay=bornOnWhichDay(daysOld);
		System.out.println("Your Birthday is a "+bornDay+".");
		if(bornDay.contentEquals("Sunday"))
		   System.out.println("And Sunday's child is bonny and blithe, and good and gay!");
		
		//check if today's birthday   
		checkBirthday(y,m,d);
		//check if daysOld is divisible by 100
		hundred(daysOld);
		//get metric years old
		metricYearsOld(daysOld);
	}
	
	public static void main(String args[]) {
		Birthday b=new Birthday(-4,12,24);
		
	}
	
	
	public String bornOnWhichDay(int daysOld) {
		//we use days old because that symbolize the days
		//different between now and our birthday
		if(checkCalendarFirstDayisSunday()) {
			
			int weekdayBorn=(7 + weekdayNow - (daysOld%7))%7;
			 return weekday[weekdayBorn];
		}
		   
		else 
			return "error";
		//because if calendar first day is not a Sunday
		//then our weekday array will need to be rearranged
		
	}
	public boolean checkCalendarFirstDayisSunday() {
		Calendar now = Calendar.getInstance();  
	
		boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);  
		
		int weekDay = now.get(Calendar.DAY_OF_WEEK);  
	
		//just to check if calendar day of week starts with sunday
		if(isFirstSunday){  
		//  System.out.println("is first sun");
		  //System.out.println(weekdayNow);
			return true;
		  
		}  
		return false;
//		   weekDay = weekDay - 1;  
//		    if(weekDay == 0){  
//		        weekDay = 7;  
//		    }  
	}
	public void checkBirthday(int y, int m, int d) {
		if (m==monthNow && d==dayNow)		
			System.out.println("Happy "+yearOld(y)+"th birthday!");
	    
	}
	public int yearOld(int y) {
		
		int year=yearNow;
		return year-y;//years old
		
	}
	public String dateFormat(int year, int month, int day) {
		if(year<0)
			return Math.abs(year)+"BC."+month+"."+day;
		return year+"."+month+"."+day;
	}
	public void getToday() {
		Date date=new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		yearNow = cal.get(Calendar.YEAR);
		monthNow = cal.get(Calendar.MONTH)+1;
		dayNow = cal.get(Calendar.DAY_OF_MONTH);
		weekdayNow= cal.get(Calendar.DAY_OF_WEEK)-1;//1-7 sun-sat
		
	}
	public int todayInJD() {
			
		return gregToJD(yearNow, monthNow, dayNow);
	}
	//divisible by 100?
	public void hundred(int d) {
		if(d%100==0) {
			System.out.println("You have lived "+d/100+" of 100 days.");
		}
	
	}
	public void metricYearsOld(int daysOld) {
		
		System.out.println("In Metric Calendar, you are "
		+daysOld/1000+" years old." );

	}
}
