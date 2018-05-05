package se.kth.iv1350.pointofsale.integration;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;


public class ItemCatalog {

	/*****************************
	 * Used for storing all the items in a database.
	 *****************************/
    HashMap<ItemIdentifier, Item> itemCatalog = new HashMap<ItemIdentifier, Item>();
    /*****************************
	 * The constructor adds all the items to the database as its initiated 
	 * through @method addItems.
	 *****************************/    
	public ItemCatalog() {

		addItems();
	}
	/*********************************************************
	 * The code is searched for in the database to find an item that matches the code.
	 * If no match, return null.
	 * 
	 * @param itemIdentifier		The code entered by the user. Stored as an Object to allow
	 * 							HashMap manipulation
	 * 
	 * @return 					Returns an Object with all information of 
	 * 							the items to the system and user.
	 *********************************************************/

	public Item searchForItem(ItemIdentifier itemIdentifier) {
		
		if (this.itemCatalog.containsKey(itemIdentifier)) {
			return this.itemCatalog.get(itemIdentifier); 
			}
		return null; 	
	}

	
	/*****************************
	 * Adds new items to the <code>itemCatalog</code> ,HashMap.
	 * First of <code>itemCatalog</code>  @param input is for itemIdentifier
	 * Second of <code>itemCatalog</code>  @param input is for all parameter in the Item constructor.
	 * 
	 * ItemIdentifier itemCode, String itemName, int price,String tax, String description
	 *****************************/        
    private void addItems() {
    	    	
		Item coconut = new Item(new ItemIdentifier(100), "Coconut", new AmountOfCash(10), "12%", "Origin: UK" );
    	
			this.itemCatalog.put(coconut.getItemCode(),coconut);

    		Item Water = new Item(new ItemIdentifier(200),"Bottled Water",new AmountOfCash(9), "12%", "BottledWaterCo");
    		
    			this.itemCatalog.put(Water.getItemCode(),Water);
    		
    		Item Soap = new Item(new ItemIdentifier(300), "Soap", new AmountOfCash(6), "12%","Don't eat");
  		  
    			this.itemCatalog.put(Soap.getItemCode(),Soap);

    		 
    	}
}


