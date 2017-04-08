package com.anant.beans;

import java.util.HashMap;

public class Station {
     private static HashMap<String, Integer> lStationArray = new HashMap<>();

     public Station() {
    	 lStationArray.put("A1", 1);
    	 lStationArray.put("A2", 2);
    	 lStationArray.put("A3", 3);
    	 lStationArray.put("A4", 4);
    	 lStationArray.put("A5", 5);
    	 lStationArray.put("A6", 6);
    	 lStationArray.put("A7", 7);
    	 lStationArray.put("A8", 8);
    	 lStationArray.put("A9", 9);
    	 lStationArray.put("A10", 10);
     }

	public static HashMap<String, Integer> getlStationArray() {
		return lStationArray;
	}

}
