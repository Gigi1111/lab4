package lab4;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void testDaysBetween() {
		JulianDate jd= new myJulianDate();
		int d=jd.daysBetween(2019,10,31,2018,10,31);
		System.out.println("hi");
		assertEquals(d,363);
	}

}
