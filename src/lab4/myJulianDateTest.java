package lab4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class myJulianDateTest {
	JulianDate jd= new myJulianDate();
	Date date=new Date(); // your date
	Calendar cal = Calendar.getInstance();
	
	@Test
	void testDaysBetween() {
		
		int d=jd.daysBetween(2019,10,31,2018,10,31);
		System.out.println(d);
		assertEquals(d,365);
		
		
	
	}
	
	@Test
	void testGregToJD() {
			
		int d=jd.gregToJD(1430,11,11);
		System.out.println(d);
		assertEquals(d,2243680);
		
		d=jd.gregToJD(1430,11,11);
		System.out.println(d);
		assertEquals(d,2243680);
		
		d=jd.gregToJD(1991,11,11);
		System.out.println(d);
		assertEquals(d,2448572);
		
		cal.setTime(date);
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH)+1;
		int dayNow = cal.get(Calendar.DAY_OF_MONTH);
		int d2=jd.daysBetween(1991,11,11,yearNow,monthNow,dayNow);
		System.out.println(d2);
		assertEquals(d2,jd.gregToJD(yearNow,monthNow,dayNow)-d);
	}

}
