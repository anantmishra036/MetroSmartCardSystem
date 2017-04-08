package com.anant.dao;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.anant.beans.SmartCard;

public class SmartCardDetailsDAO {

	private static Long lAutoIncrementKey = 0L;
	private static HashMap<Long, SmartCard> lSmartCardDetails = new HashMap<>();

	public Long save(SmartCard pSmartCard, Long pCardId) {
		if(pCardId != null) {
			lSmartCardDetails.put(pCardId, pSmartCard);
		}
		else{
			pCardId = lAutoIncrementKey+1L;
			lAutoIncrementKey++;
			lSmartCardDetails.put(pCardId, pSmartCard);
		}
		return pCardId;
	}
	
	public static SmartCard get(Long pCardId) {
		SmartCard lSmartCardToReturn = null;
		if(pCardId != null) {
			lSmartCardToReturn = lSmartCardDetails.get(pCardId);
		}
		return lSmartCardToReturn;
	}
}
