package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

import java.util.*;

public class SaleInformation {
	double runningTotal;
	Item	   mostRecentlyScannedItem;
	
	public SaleInformation(Item newItem, double runningTotal) {
		this.runningTotal += runningTotal;
		this.mostRecentlyScannedItem = newItem;
	}
	

	/*******************
	 * 
	 * 
	 *******************/
	public String toString() {
		String printItemNameAndPrice = mostRecentlyScannedItem.getItemName();
		
		printItemNameAndPrice += "   " + "Price:" + Double.toString(mostRecentlyScannedItem.getPrice());
		printItemNameAndPrice += "   " + "Total:" + Double.toString(runningTotal); 

		return printItemNameAndPrice;
	}
		
}
