package com.anant.transaction;

import com.anant.beans.SmartCard;
import com.anant.beans.Traveler;
import com.anant.dao.SmartCardDetailsDAO;

public class MainMethodClass {

	public static void main(String[] args) {
		FootFallHandler lFootFallHandler = new FootFallHandler();
		SwipeInSwipeOutHandler lSwipeInSwipeOutHandler = new SwipeInSwipeOutHandler();
		SmartCardReportGeneration lSmartCardReportGeneration = new SmartCardReportGeneration();
		SmartCardDetailsDAO lSmartCardDetailsDAO = new SmartCardDetailsDAO();
		
		
        Traveler lTraveler = new Traveler();		
        lTraveler.setUserName("Anant Mishra");
        
		SmartCard lSmartCard = new SmartCard();
		lSmartCard.setCardBalence(100);
		lSmartCard.setMinAmount(5.5f);
		lSmartCard.setTravelerInfo(lTraveler);
		lSmartCardDetailsDAO.save(lSmartCard, null);
		
		Traveler lTraveler1 = new Traveler();		
        lTraveler.setUserName("Anant Mishra 1");
        
		SmartCard lSmartCard1 = new SmartCard();
		lSmartCard1.setCardBalence(1000);
		lSmartCard1.setMinAmount(5.5f);
		lSmartCard1.setTravelerInfo(lTraveler1);
		lSmartCardDetailsDAO.save(lSmartCard1, null);
		
		
		lSwipeInSwipeOutHandler.swipeInCard(1L, "A2");
		lSwipeInSwipeOutHandler.swipeInCard(2L, "A2");
		lSwipeInSwipeOutHandler.swipeOutCard(1L, "A4");
		lFootFallHandler.getFootFallOfStation("A2");
		lSmartCardReportGeneration.displayAllCardDetails();
		lSmartCardReportGeneration.displayGivenCardDetails(1L);
		
	}
}
