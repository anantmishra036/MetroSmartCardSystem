package com.anant.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FareCalculationFactory {

	public static FareStratigy getInstance(Date pTravelDate) {
		SimpleDateFormat lSimpleDateFormat = new SimpleDateFormat("EEEE");
		String lDayofWeek = lSimpleDateFormat.format(pTravelDate);
		if("Saturday".equalsIgnoreCase(lDayofWeek) || "Sunday".equalsIgnoreCase(lDayofWeek)) {
			return new WeekdayFare();
		}
		else{
			return new WeekendFare();
		}
	}
}
