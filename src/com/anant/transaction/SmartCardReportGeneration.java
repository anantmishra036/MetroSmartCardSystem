package com.anant.transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.anant.beans.SmartCardTransactionBean;
import com.anant.dao.SmartCardDetailsDAO;
import com.anant.dao.SmartCardTransactionDetailsDAO;

public class SmartCardReportGeneration {

	public void displayAllCardDetails() {
		Set<Long> lCardNoSet = SmartCardTransactionDetailsDAO.getlSmartCardTransactionMapping().keySet();
	    for(Long lTempSet:lCardNoSet) {
	    	ArrayList<SmartCardTransactionBean> lTempList = SmartCardTransactionDetailsDAO.getlSmartCardTransactionMapping().get(lTempSet);
	    	for(SmartCardTransactionBean ltempBean: lTempList) {
	    		System.out.println("Card "+ltempBean.getSmartCardNum()+" used to travel from station "
	    	+ltempBean.getSourceStation()+" to station "+ltempBean.getDestinationStation()+". Fare is Rs "+ltempBean.getTravelFare()+
	    	" and balance on the card is "+SmartCardDetailsDAO.get(ltempBean.getSmartCardNum()).getCardBalence());	
	    	}
	    }
	    
	    lCardNoSet = SmartCardTransactionDetailsDAO.getlSmartCardTransactionDetails().keySet();
	    for(Long lTempKey: lCardNoSet) {
	    	SmartCardTransactionBean ltempBean = SmartCardTransactionDetailsDAO.getlSmartCardTransactionDetails().get(lTempKey);
    		System.out.println("Card "+ltempBean.getSmartCardNum()+" used to travel from station "
    	+ltempBean.getSourceStation()+" to station "+ltempBean.getDestinationStation()+". Fare is Rs "+ltempBean.getTravelFare()+" and balance on the card is"
    	+SmartCardDetailsDAO.get(ltempBean.getSmartCardNum()).getCardBalence());	
    	}
	}
	
	public void displayGivenCardDetails(Long pCardNum) {
		Set<Long> lCardNoSet = SmartCardTransactionDetailsDAO.getlSmartCardTransactionMapping().keySet();
	    for(Long lTempSet:lCardNoSet) {
	    	if(pCardNum.equals(lTempSet)) {
	    	ArrayList<SmartCardTransactionBean> lTempList = SmartCardTransactionDetailsDAO.getlSmartCardTransactionMapping().get(lTempSet);
	    	for(SmartCardTransactionBean ltempBean: lTempList) {
	    		System.out.println("Card "+ltempBean.getSmartCardNum()+" used to travel from station "
	    	+ltempBean.getSourceStation()+" to station "+ltempBean.getDestinationStation()+". Fare is Rs "+ltempBean.getTravelFare()+" and balance on the card is "+
	    	+SmartCardDetailsDAO.get(ltempBean.getSmartCardNum()).getCardBalence());	
	    	}
	    	}
	    }
	    
	    lCardNoSet = SmartCardTransactionDetailsDAO.getlSmartCardTransactionDetails().keySet();
	    for(Long lTempKey: lCardNoSet) {
	    	if(pCardNum.equals(lTempKey)) {
	    	SmartCardTransactionBean ltempBean = SmartCardTransactionDetailsDAO.getlSmartCardTransactionDetails().get(lTempKey);
    		System.out.println("Card "+ltempBean.getSmartCardNum()+" used to travel from station "
    	+ltempBean.getSourceStation()+" to station "+ltempBean.getDestinationStation()+". Fare is Rs "+ltempBean.getTravelFare()+" and balance on the card is "
    				+SmartCardDetailsDAO.get(ltempBean.getSmartCardNum()).getCardBalence());	
    	}
	    }
	}
	
}
