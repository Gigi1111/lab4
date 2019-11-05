package lab4;

public class myJulianDate implements JulianDate {

	public static void main(String args[]) {
		myJulianDate jd=new myJulianDate();
		System.out.println(jd.gregToJD(2019,11,5));//2458793
		System.out.println(jd.gregToJD(1920,9,15));//2422583
		System.out.println(jd.gregToJD(1490,4,23));//2265393
		System.out.println(jd.daysBetween(1999,10,31,2000,10,31));
	}

	public int gregToJD(int y, int m, int d) {
		// TODO Auto-generated method stub
		myJulianDate jd=new myJulianDate();
		int yg=jd.yearGreg;
		int mg=jd.yearGreg;
		int dg=jd.yearGreg;

		int sum=0;
		int daysInYear = ((y-1)-yg)*365 + ((y-1)-yg)/4;
		if(y>1582) {
			int notLeaped = (y/100-15) - (y/400 - 3);
			daysInYear=daysInYear -notLeaped -10;
		}
		sum=daysInYear;
		for(int i=1;i<m;i++) {
			sum+=jd.daysInMonth[i];
		}
		sum+=d;
		
		return sum;

	}

	@Override
	public void JDtoGreg(int days) {
		// TODO Auto-generated method stub
		
	}
	public int daysBetween(int y1,int m1, int d1, int y2, int m2, int d2) {
		myJulianDate jd=new myJulianDate();
		return Math.abs( jd.gregToJD(y1,m1,d1)-jd.gregToJD(y2, m2, d2));
	}


	

}
