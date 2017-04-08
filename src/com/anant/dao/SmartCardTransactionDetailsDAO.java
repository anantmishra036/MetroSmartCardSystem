package com.anant.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.anant.beans.SmartCard;
import com.anant.beans.SmartCardTransactionBean;
import com.anant.customException.TransactionFailException;

public class SmartCardTransactionDetailsDAO {

	private static HashMap<Long, SmartCardTransactionBean> lSmartCardTransactionDetails = new HashMap<>();
	private static HashMap<Long, ArrayList<SmartCardTransactionBean>> lSmartCardTransactionMapping = new HashMap<>();
	private static ConcurrentHashMap<String, Long> lStationSwipeInCountmap = new ConcurrentHashMap<>();
	private static ConcurrentHashMap<String, Long> lStationSwipeOutCountmap = new ConcurrentHashMap<>();
	public static HashMap<Long, SmartCardTransactionBean> getlSmartCardTransactionDetails() {
		return lSmartCardTransactionDetails;
	}

	public static HashMap<Long, ArrayList<SmartCardTransactionBean>> getlSmartCardTransactionMapping() {
		return lSmartCardTransactionMapping;
	}


	public Long save(SmartCardTransactionBean pSmartCardTransactionBean, Long pCardNum,
			boolean pIsSwipeIn) throws TransactionFailException{
		if(!pIsSwipeIn) {
			validateInsufficientBalance(pCardNum,pSmartCardTransactionBean.getTravelFare() );
			float lnewBal = SmartCardDetailsDAO.get(pCardNum).getCardBalence() - pSmartCardTransactionBean.getTravelFare();
			SmartCardDetailsDAO.get(pCardNum).setCardBalence(lnewBal);
			new SmartCardDetailsDAO().save(SmartCardDetailsDAO.get(pCardNum), pCardNum);
			ArrayList<SmartCardTransactionBean> lTempCardMapList = new ArrayList<>();
			if(lSmartCardTransactionMapping.get(pCardNum) != null) {
				lTempCardMapList = lSmartCardTransactionMapping.get(pCardNum);
			}
			lTempCardMapList.add(lSmartCardTransactionDetails.get(pCardNum));
			if(lStationSwipeOutCountmap.get(pSmartCardTransactionBean.getSourceStation()) != null) {
			lStationSwipeOutCountmap.put(pSmartCardTransactionBean.getSourceStation(),
					lStationSwipeOutCountmap.get(pSmartCardTransactionBean.getSourceStation())+1);
			}
			else{
				lStationSwipeOutCountmap.put(pSmartCardTransactionBean.getSourceStation(),1L);
			}
			lSmartCardTransactionMapping.put(pCardNum, lTempCardMapList);
			lSmartCardTransactionDetails.remove(pCardNum);
		}
		else{
			validateMinimumBalance(pCardNum);
			if(lStationSwipeInCountmap.get(pSmartCardTransactionBean.getSourceStation()) != null) {
			lStationSwipeInCountmap.put(pSmartCardTransactionBean.getSourceStation(),
					lStationSwipeInCountmap.get(pSmartCardTransactionBean.getSourceStation())+1);
			}
			else{
				lStationSwipeInCountmap.put(pSmartCardTransactionBean.getSourceStation(),1L);
			}
			lSmartCardTransactionDetails.put(pCardNum, pSmartCardTransactionBean);
		}
		return pCardNum;
	}
	
	public static ConcurrentHashMap<String, Long> getlStationSwipeInCountmap() {
		return lStationSwipeInCountmap;
	}

	public static ConcurrentHashMap<String, Long> getlStationSwipeOutCountmap() {
		return lStationSwipeOutCountmap;
	}

	private boolean validateMinimumBalance(long pCardNum) throws TransactionFailException{
		SmartCard lSmartCard = SmartCardDetailsDAO.get(pCardNum);
		if(lSmartCard.getCardBalence() < lSmartCard.getMinAmount()) {
			System.out.println("Please maintain minimum balance - "+lSmartCard.getMinAmount());
			throw new TransactionFailException("Minimum balance is not present");
		}
		return true;
	}
	
	private boolean validateInsufficientBalance(long pCardNum, float pTravelFare) throws TransactionFailException{
		SmartCard lSmartCard = SmartCardDetailsDAO.get(pCardNum);
		if(lSmartCard.getCardBalence() < pTravelFare) {
			System.out.println("Insufficient balance - "+lSmartCard.getCardBalence());
			throw new TransactionFailException("Insufficient balance");
		}
		return true;
	}
	
	public static SmartCardTransactionBean get(Long pCardNum) {
		SmartCardTransactionBean lSmartCardTransactionToReturn = null;
		if(pCardNum != null) {
			lSmartCardTransactionToReturn = lSmartCardTransactionDetails.get(pCardNum);
		}
		return lSmartCardTransactionToReturn;
	}
}
