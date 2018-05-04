package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;
import java.time.LocalDateTime;
/**
 * Collects all information regarding a particular sale.
 */
public class Sale {
	private SaleInformation SaleInfo;
	private ItemDTO itemAvailableForSale;
	private ItemCatalog ListOfItems;
	//private final SaleInformation SaleDTO;
	
	/****************************
	 * Used for calculating the amount of items that has been scanned.
	 ****************************/
    static HashMap<ItemDTO, Integer> scannedItems = new HashMap<ItemDTO, Integer>();

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
     * Finds whether an item exists with the itemIdentifier, code, and returns it as:
     * 
     * @return null 		If there are no item with matching itemIdentifier it returns nothing.
     * 					Prints out error message.
     * @return item 		If there's a match the method return an item object.
     ****************************/
    public ItemDTO addItem(ItemIdentifier ItemIdentifier) {	
    	if(ListOfItems.searchForItem(ItemIdentifier) ==null){
    		
    		System.out.println("Item doesn't exist in the database. Please try again.");
    		
    		return null;
    		}else
    			increaseQuantity(ItemIdentifier);
    			return itemAvailableForSale = ListOfItems.searchForItem(ItemIdentifier);
    }
    
	/****************************
	 * 
	 * S
	 ****************************/
    public void saveToSaleInformation(ItemDTO Item){
    		SaleInfo
    }
    
    /****************************
     * Adds item to scannedItems by increase quantity of an existing item in the cart
     * or by adding a new item to the cart.
     * 
     * @param ItemIdentifier New item that has been scanned.
     ****************************/
    public void increaseQuantity(ItemIdentifier identifier) {
    	
    		if(scannedItems.containsKey(identifier)){
    			ItemDTO ItemPlaceHolder = (ItemDTO) identifier;
    			scannedItems.put(ItemPlaceHolder, scannedItems.get(ItemPlaceHolder) + 1);
    		}else{
    			ItemDTO ItemPlaceHolder = (ItemDTO) identifier;
    			scannedItems.put(ItemPlaceHolder, 1);
    		}
    }
    
    
    
    
    /*
     * Shows the Item that has been scanned as a text for the cashier.
     * NOT IN USE
     * @param NewlyAddedItem 	The item that has been just searched and added to the ScannedItems
     */
    	public void showAddedItem (Object NewlyAddedItem) {
    		NewlyAddedItem.toString();
    	}
    	
    	
    			
    
}
