package lab4;

import java.util.Calendar;
import java.util.Date;

/*
 * A metric system is proposed to reform the calendar. 
 * It will have 10 regular days are a week, 
 * 10 weeks a month, 10 months a year.
 *  Extend your JulianDate class to a class MetricDate
 *   that has a method for converting from JulianDate 
 *   to metric and from metric to JulianDate. 
 *   How old are both of you on this metric system in years??

 */
public class Metric extends myJulianDate{

	public Metric(int y,int m, int d) {
		super();
		int daysOld = gregToJD(y,m,d);
		JDToMetric(daysOld);
	}
	public static void main(String args[]) {
		Metric m=new Metric(1991,8,31);
		
	}
	public int metricToJD(int y10,int m10,int d10) {
		return 0;
	}
	public void JDToMetric(int days) {
		//10 days a week, 10 weeks a month, 10 month a year
		//a week:10 days, a month:100days, year:1000days
		Date date=new Date(); // your date
		// Choose time zone in which you want to interpret your Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int diff = gregToJD(year,month,day)-days;
		System.out.println("In Metric Calendar, you are "+diff/1000+" years old." );
	}
}
