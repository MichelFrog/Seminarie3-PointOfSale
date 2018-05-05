package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

import java.util.*;

public class SaleInformation {
	AmountOfCash runningTotal;
	Item	   lastScannedItem;

	/*
	 * Constructor for SaleInformation without any parameters.
	 */
	public SaleInformation() { 
		if( lastScannedItem == null) {
			runningTotal = new AmountOfCash();
			lastScannedItem = new Item();
		}

	}
	/*public SaleInformation(Item newItem, AmountOfCash price) {
		if(runningTotal== null) {
			runningTotal = new AmountOfCash();
			lastScannedItem = new Item();
		}
		this.runningTotal = runningTotal.plus(price);
		this.lastScannedItem = newItem;
	}*/
	

	/*************************************
	 * Creates a string for printing out the Name, 
	 * price of the item and the current running total.
	 *************************************/
	public String toString() {
		Sale temporarySale = new Sale();
		String printItemNameAndPrice = temporarySale.getScannedItem().getItemName();
		
		printItemNameAndPrice += "   " + "\n"+"Price:" + Double.toString(lastScannedItem.getPrice());
		printItemNameAndPrice += "   " + "\n"+"Total:" + runningTotal.toString(); 

		return printItemNameAndPrice;
	}
	
	/*************************************
	 * Getter for runningTotal AmountOfCash.
	 * 
	 * @return The runningTotal is returned.
	 *************************************/
	public AmountOfCash updateRunningTotal() {
		return runningTotal;
	}
	
	public getLastItemScanned() {
		this.lastScannedItem = Sale.newlyAddedItem;
	}
		
}
