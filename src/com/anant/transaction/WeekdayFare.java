package com.anant.transaction;

public class WeekdayFare implements FareStratigy{

	private float I_PerStationFare = 5.5f;

	@Override
	public float getCalculatedFare(Integer pDistance) {
		return I_PerStationFare * pDistance;
	}

}
