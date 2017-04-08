package com.anant.beans;

public class SmartCard {

     private float minAmount = 5.5f;
     private Traveler travelerInfo;
     private float cardBalence;
	public float getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(float minAmount) {
		this.minAmount = minAmount;
	}
	public Traveler getTravelerInfo() {
		return travelerInfo;
	}
	public void setTravelerInfo(Traveler travelerInfo) {
		this.travelerInfo = travelerInfo;
	}
	public float getCardBalence() {
		return cardBalence;
	}
	public void setCardBalence(float cardBalence) {
		this.cardBalence = cardBalence;
	}
     
}
