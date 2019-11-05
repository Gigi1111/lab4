package lab4;

public interface JulianDate {
	public static final int yearGreg = -4713;
	 public static final int monthGreg = 1;
	public static final int dateGreg = 1;
	static final int[] daysInMonth= {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	
	//void initializeStartDate();
	int gregToJD(int y, int m, int d);
	
	void JDtoGreg(int days);
	
	//arithmatics

	int daysBetween(int y1,int m1, int d1, int y2, int m2, int d2);
	
	
	
	
	
}

