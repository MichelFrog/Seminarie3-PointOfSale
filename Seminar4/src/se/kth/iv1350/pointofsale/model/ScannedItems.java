package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;
import java.util.*;

public class ScannedItems {

	/*******************************************************
	 * Used for calculating the amount of items that has been scanned.
	 *******************************************************/
	private HashMap<Item,Integer> scannedItems;

	public ScannedItems() {
		scannedItems = new HashMap<>();
	}


	/**********************************************************************************
	 * Adds item to scannedItems by increase quantity of an existing item in the cart
	 * or by adding a new item to the cart.
	 * 
	 * @param ItemIdentifier New item that has been scanned.
	 **********************************************************************************/
	public void increaseQuantityOfScannedItems(Item newlyScannedItem) {
		if(existInCart(newlyScannedItem) == true) {
			addToCart(newlyScannedItem, quantityOfItem(newlyScannedItem) +1);
		}else {
			addToCart(newlyScannedItem, 1);
		}
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

	/*******************************************************************************
	 * Creates a StringBuilder representation of all the items in the <code>ScannedItems</code> class
	 * Makes use of the iteration function that goes through each entry in the HashMap.
	 * 
	 * @return String the item list in a string format that can is used by 
	 * 				  <code>Printer</code> and <code>Receipt</code> 
	 ******************************************************************************/
	public String toString(){
		StringBuilder buildListOfSoldItems = new StringBuilder();
		Iterator iteratorForSoldItems = scannedItems.entrySet().iterator();
		while(iteratorForSoldItems.hasNext()){
			Map.Entry pair = (Map.Entry) iteratorForSoldItems.next();
			buildListOfSoldItems.append(pair.getKey() + " x" + pair.getValue()+"\n");
		}
		return buildListOfSoldItems.toString();
	}


}

