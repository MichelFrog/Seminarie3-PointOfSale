package se.kth.iv1350.pointofsale.integration;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;


public class ItemCatalog {

	/*****************************
	 * Used for storing all the items in a database.
	 *****************************/
    HashMap<ItemIdentifier, ItemDTO> itemCatalog = new HashMap<ItemIdentifier, ItemDTO>();
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

	public ItemDTO searchForItem(Object ItemIdentifier) {
		if (this.itemCatalog.containsKey(ItemIdentifier)) {
			ItemDTO item = (ItemDTO) this.itemCatalog.get(ItemIdentifier);
			return item; 
			}
		return null; 	
	}

	
	/*****************************
	 * Adds new items to the itemCatalog HashMap.
	 * First of <code>itemCatalog</code>  @param input is for itemIdentifier
	 * Second @param input is for all parameter in the ItemDTO constructor.
	 *****************************/        
    private void addItems() {
    this.itemCatalog.put(new ItemIdentifier(1),new ItemDTO("Coconut", 10, "12%", "Origin: UK"));
    	this.itemCatalog.put(new ItemIdentifier(2),new ItemDTO("Bottled Water",12, "12%", "BottledWaterCo"));
    this.itemCatalog.put(new ItemIdentifier(3),new ItemDTO("Soap", 18, "12%","Don't eat"));
    	}
}


