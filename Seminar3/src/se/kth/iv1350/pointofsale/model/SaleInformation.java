package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

import java.time.LocalDateTime;
import java.util.*;

public class SaleInformation {
	private AmountOfCash runningTotal;
	private ScannedItems	   scannedItems;
	private Item newlyAddedItem;
    private LocalDateTime saleTime;


	/************************************
	 * Constructor for SaleInformation without any parameters.
	 ************************************/
	public SaleInformation() { 
	        runningTotal = new AmountOfCash(0);
	        scannedItems = new ScannedItems();
	        this.saleTime = LocalDateTime.now();
	}
	
    public SaleDTO updateSale(Item newlyScannedItem) {
		
    		scannedItems.increaseQuantityOfScannedItems(newlyScannedItem);
		runningTotal.add(newlyScannedItem.getPrice());
		newlyAddedItem = newlyScannedItem;
		return getSaleInformation();
    }
    
	/*************************************
	 * NOT IN USE
	 * Creates a string for printing out the Name, 
	 * price of the item and the current running total.
	 *************************************/
	public String toString() {
		Sale temporarySale = new Sale();
		String printItemNameAndPrice = temporarySale.getScannedItem().getItemName();
		
		printItemNameAndPrice += "   " + "\n"+"Price:" + Double.toString(newlyAddedItem.getPrice());
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
	/**************************************
	 * Getter method for SaleInformation
	 * 
	 * @param runningTotal  the current running total.
	 * @param newlyAddedItem most recently added item.
	 * @param scannedItems	HashMap of all the items 
	 * that has been scanned;
	 * 
	 **************************************/
    public SaleDTO getSaleInformation(){
        return new SaleDTO(runningTotal,newlyAddedItem,scannedItems);
    }
    
    /**************************************
     * Setter for the running total.
     **************************************/
    public void setRunningTotal(AmountOfCash runningTotal) {
        this.runningTotal = runningTotal;
    }
    /**************************************
     * Setter for the running total.
     **************************************/
    public AmountOfCash getRunningTotal() {
        return runningTotal;
    }
    
    /**************************************
     * Setter for the running total.
     **************************************/
    public void setTimeOfSale() {
        this.saleTime = LocalDateTime.now();
    }
    
    /*************************************
    * @return The last scanned and added item.
    **************************************/
    public ScannedItems  getScannedItems() {
    		return scannedItems;
    
    }
    /***************************************
    * @return The last scanned and added item.
    **************************************/
    public Item getnewlyAddedItem() {
       return newlyAddedItem;
}

		
}
