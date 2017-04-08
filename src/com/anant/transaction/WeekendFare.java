package com.anant.transaction;

public class WeekendFare implements FareStratigy {

	private float I_PerStationFare = 7f;

	@Override
	public float getCalculatedFare(Integer pDistance) {
		return I_PerStationFare * pDistance;
	}

}
