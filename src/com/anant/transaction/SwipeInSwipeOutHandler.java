package com.anant.transaction;

import java.util.Date;

import com.anant.beans.SmartCardTransactionBean;
import com.anant.beans.Station;
import com.anant.customException.TransactionFailException;
import com.anant.dao.SmartCardDetailsDAO;
import com.anant.dao.SmartCardTransactionDetailsDAO;

public class SwipeInSwipeOutHandler {

	public void swipeInCard(Long pCardNo, String pSourceStation) {
		if(SmartCardDetailsDAO.get(pCardNo) == null) {
			System.out.println("Card is not valid");
			return;
		}
		if(SmartCardTransactionDetailsDAO.get(pCardNo) != null) {
			System.out.println("Previous transaction was not proper. Please first swipe out your card");
			return;
		}
		SmartCardTransactionBean lSmartCardTransactionBean = new SmartCardTransactionBean();
		lSmartCardTransactionBean.setSourceStation(pSourceStation);
		lSmartCardTransactionBean.setSmartCardNum(pCardNo);
		try{
			new SmartCardTransactionDetailsDAO().save(lSmartCardTransactionBean, pCardNo, true);
			System.out.println("Card "+pCardNo+" swipe in successfully");
		}
		catch(TransactionFailException e) {
			System.out.println("Transaction failed due to given reason "+e.getMessage());
		}
	}

	public void swipeOutCard(Long pCardNo, String pDestinationStation) {
		if(SmartCardDetailsDAO.get(pCardNo) == null) {
			System.out.println("Card is not valid");
			return;
		}
		if(SmartCardTransactionDetailsDAO.get(pCardNo) == null) {
			System.out.println("Previous transaction was not proper. Please first swipe in your card");
			return;
		}

		SmartCardTransactionBean lSmartCardTransactionBean = SmartCardTransactionDetailsDAO.get(pCardNo);
		lSmartCardTransactionBean.setDestinationStation(pDestinationStation);
		lSmartCardTransactionBean.setSmartCardNum(pCardNo);
		Integer lSourceDestinationDistance = sourceDestinationDestinationCalculation(lSmartCardTransactionBean.getSourceStation(),pDestinationStation);
		float lTravelFare = FareCalculationFactory.getInstance(new Date()).getCalculatedFare(lSourceDestinationDistance);
		lSmartCardTransactionBean.setTravelFare(lTravelFare);
		try{
			new SmartCardTransactionDetailsDAO().save(lSmartCardTransactionBean, pCardNo, false);
			System.out.println("Card "+pCardNo+" swipe out successfully");
		}
		catch(TransactionFailException e) {
			System.out.println("Transaction failed due to given reason "+e.getMessage());
		}
	}

	public Integer sourceDestinationDestinationCalculation(String pSourceStation, String pDestinationStation) {
		Station lStation = new Station();
		if(!lStation.getlStationArray().containsKey(pSourceStation)) {
			System.out.println("Source Station is not correct");
			throw new NullPointerException();
		}
		if(!lStation.getlStationArray().containsKey(pDestinationStation)) {
			System.out.println("Destination Station is not correct");
			throw new NullPointerException();
		}
		return lStation.getlStationArray().get(pDestinationStation) - lStation.getlStationArray().get(pSourceStation);

	}

}
