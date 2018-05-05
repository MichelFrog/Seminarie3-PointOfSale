package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;
import java.time.LocalDateTime;
/********************************************************
 * Collects all information regarding a particular sale.
 *******************************************************/
public class Sale {
	private Item             newlyAddedItem;
	
	private ItemCatalog      listOfItems;
	
	private AmountOfCash		runningTotal;
	/********************************************************
	 * Collects all information regarding a particular sale.
	 *******************************************************/ 
	private SaleInformation  saleInfo;

    private LocalDateTime saleTime;
    
	/*******************************************************
	 * Used for calculating the amount of items that has been scanned.
	 *******************************************************/
    static HashMap<Item, Integer> scannedItems = new HashMap<Item, Integer>();
    /***************************************************************
     * Creates a new instance, and records the time it was created. 
     * This will be the time recorded on the receipt.
     ***************************************************************/
    public Sale() { 
    	this.saleInfo = new SaleInformation();
    	this.runningTotal = new AmountOfCash();
    	this.newlyAddedItem = new Item();
    	saleTime = LocalDateTime.now();
    }
    
    /**********************************************************************************
     * Creates updates the instance of saleInfo with new running total and most recently added item
     * @return null 		If there are no item with matching itemIdentifier it returns null.
     * 					Prints out error message in View.
     * @return item 		If there's a match the method return an item object.
     **********************************************************************************/
    public SaleInformation addItem(Item item) {	
		this.runningTotal = new AmountOfCash(item.getPrice());
    		this.saleInfo = new SaleInformation();
    		increaseQuantityOfItemsInCart(item);
    		
    		return saleInfo;
    }
    /************************
     * Creates updates the instan
     * Updates the saleinformation
     ************************/
    public SaleInformation updateSale(Item newlyScannedItem) {
    		
    		increaseQuantityOfItemsInCart(newlyScannedItem);
    		runningTotal.add(newlyScannedItem.getPrice());
    		newlyAddedItem = newlyScannedItem;
    		return getSaleInformation();
    }
    
	/**********************************************************************************
	 * Fetches most recent running total.
	 * 
	 * @return fetches the most recent running total from SaleInformation,
	 **********************************************************************************/
  //  public double getRunningTotal() {
    		//return this.amount = saleInfo.getRunningTotal();
   // }
    
    /**********************************************************************************
     * Adds item to scannedItems by increase quantity of an existing item in the cart
     * or by adding a new item to the cart.
     * 
     * @param ItemIdentifier New item that has been scanned.
     **********************************************************************************/
    public void increaseQuantityOfItemsInCart(Item newlyScannedItem) {
		if(existInCart(newlyScannedItem) == true) {
			addToCart(newlyScannedItem, quantityOfItem(newlyScannedItem) +1);
		}else {
			addToCart(newlyScannedItem, 1);
		}
    }

    
    /**********************************************************************************
     * Shows the Item that has been scanned as a text for the cashier.
     * NOT IN USE YET
     * @param NewlyAddedItem 	The item that has been just searched and 
     * 							added to the ScannedItems
     **********************************************************************************/
    	public void showAddedItem(Item newlyAddedItem) {
    		newlyAddedItem.toString();
    	}
    	
    	/******************************
    	 * Gets the current saleInformation
    	 *******************************/
    	public SaleInformation getSaleInformation(){
    		return saleInfo;
    	}
    	
    	/******************************
    	 * Check whether an item consists within scannedItems HashMap
    	 *******************************/    			
    	public boolean existInCart (Item itemToBeAdded) {
    		return scannedItems.containsKey(itemToBeAdded);    	
    		
    		}
    	
    	/******************************
    	 * Adds new item to the scannedItems HashMap. 
    	 * Makes other methods more readable
    	 *******************************/
    public void addToCart(Item item, Integer quantity) {
    		scannedItems.put(item, quantity);
    	}
    
	/******************************
    	 * Checks the current quantity of an item within the HashMap. 
    	 * Makes other methods more readable
	 *******************************/
    public Integer quantityOfItem(Item itemToBeAdded) {
    		return scannedItems.get(itemToBeAdded);
    }
    
    public Item getScannedItem() {
    		return newlyAddedItem;
    }
    
    public AmountOfCash getSaleIntoRunningTotal() {
    		return runningTotal;
    }

}
