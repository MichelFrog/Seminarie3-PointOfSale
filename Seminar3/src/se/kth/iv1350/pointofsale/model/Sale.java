package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;
import java.time.LocalDateTime;
/**
 * Collects all information regarding a particular sale.
 */
public class Sale {
	private SaleInformation  saleInfo;
	private Item             newlyAddedItem;
	private ItemCatalog      listOfItems;
	//private final SaleInformation SaleDTO;
	
	/****************************
	 * Used for calculating the amount of items that has been scanned.
	 ****************************/
    static HashMap<Item, Integer> scannedItems = new HashMap<Item, Integer>();

	/*****************************
	 * Collects all information regarding a particular sale.
	 ****************************/
    private LocalDateTime saleTime;
    /*****************************
     * Creates a new instance, and records the time it was created. This will be the time recorded
     * on the receipt.
     ****************************/
    
    public Sale() { 
    	saleTime = LocalDateTime.now();
    }
    
    /****************************
     * Creates updates the instance of saleInfo with new running total and most recently added item
     * 
     * @return null 		If there are no item with matching itemIdentifier it returns nothing.
     * 					Prints out error message.
     * @return item 		If there's a match the method return an item object.
     ****************************/
    public SaleInformation addItem(Item item) {	
    		this.saleInfo = new SaleInformation(item, (double)item.getPrice());
    		return this.saleInfo;
    }
    
	/****************************
	 * 
	 * S
	 ****************************/
    public double getRunningTotal() {
    		
    }
    
    /****************************
     * Adds item to scannedItems by increase quantity of an existing item in the cart
     * or by adding a new item to the cart.
     * 
     * @param ItemIdentifier New item that has been scanned.
     ****************************/
    public void increaseQuantity(Item newItem) {
    	
    		if(scannedItems.containsValue(newItem)){
    			scannedItems.put(newItem, new Integer(scannedItems.get(newItem) + 1));
    		}else{
    			
    			scannedItems.put(newItem, 1);
    		}
    }

    
    /****************************
     * Shows the Item that has been scanned as a text for the cashier.
     * NOT IN USE YET
     * @param NewlyAddedItem 	The item that has been just searched and added to the ScannedItems
     ****************************/
    	public void showAddedItem(Item newlyAddedItem) {
    		newlyAddedItem.toString();
    	}
    	
    public void	getRunningTotal( ) {
    	
    	
    }
    			
    
}
