package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

import java.util.*;

public class SaleInformation {
	double runningTotal;
	Item	   mostRecentlyScannedItem;
	
	public SaleInformation(Item newItem) {
		this.runningTotal += newItem.getPrice();
		this.mostRecentlyScannedItem = newItem;
	}
	

	/*******************
	 * Creates a string for printing out the Name, price of the item and the current running total.
	 * 
	 *******************/
	public String toString() {
		String printItemNameAndPrice = mostRecentlyScannedItem.getItemName();
		
		printItemNameAndPrice += "   " + "Price:" + Double.toString(mostRecentlyScannedItem.getPrice());
		printItemNameAndPrice += "   " + "Total:" + Double.toString(runningTotal); 

		return printItemNameAndPrice;
	}
	
	public double getRunningTotal() {
		return runningTotal;
	}
		
}
