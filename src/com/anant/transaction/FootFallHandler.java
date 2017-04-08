package com.anant.transaction;

import com.anant.beans.Station;
import com.anant.dao.SmartCardTransactionDetailsDAO;

public class FootFallHandler {

	public void getFootFallOfStation(String pStation) {
		Station lStation = new Station();
		if(!lStation.getlStationArray().containsKey(pStation)) {
			System.out.println("Invalid Station");
			return;
		}
		System.out.println("Number of users Swipe in on "+pStation+" station "
		+SmartCardTransactionDetailsDAO.getlStationSwipeInCountmap().get(pStation));
		System.out.println("Number of users Swipe out on "+pStation+" station "
				+SmartCardTransactionDetailsDAO.getlStationSwipeOutCountmap().get(pStation));
	}
}
