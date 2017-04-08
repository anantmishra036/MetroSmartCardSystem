package com.anant.beans;

import java.util.Date;

public class SmartCardTransactionBean {
	private Long smartCardNum;
	private String sourceStation;
	private String destinationStation;
	private float travelFare;
	public Long getSmartCardNum() {
		return smartCardNum;
	}
	public void setSmartCardNum(Long smartCardNum) {
		this.smartCardNum = smartCardNum;
	}
	public String getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(String sourceStation) {
		if(sourceStation != null) {
		this.sourceStation = sourceStation;
		}
		else{
			System.out.println("Source can not be null;");
			throw new NullPointerException();
		}
	}
	public String getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(String destinationStation) {
		if(destinationStation != null) {
		this.destinationStation = destinationStation;
		}
		else{
			System.out.println("Destination can not be null;");
			throw new NullPointerException();
		}
	}
	public float getTravelFare() {
		return travelFare;
	}
	public void setTravelFare(float travelFare) {
		this.travelFare = travelFare;
	}

}
