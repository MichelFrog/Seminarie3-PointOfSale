package se.kth.iv1350.pointofsale.integration;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;


public class ItemCatalog {

	/*****************************
	 * Used for storing all the items in a database.
	 *****************************/
    static HashMap<ItemIdentifier, Object> itemCatalog = new HashMap<ItemIdentifier, Object>();

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

	public static ItemDTO searchForItem(Object ItemIdentifier) {
		if (itemCatalog.containsKey(ItemIdentifier)) {
			ItemDTO item = (ItemDTO) itemCatalog.get(ItemIdentifier);
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
    	itemCatalog.put(new ItemIdentifier(1),new ItemDTO("Coconut", 10, "12%", "Origin: UK"));
    	itemCatalog.put(new ItemIdentifier(2),new ItemDTO("Bottled Water",12, "12%", "BottledWaterCo"));
    	itemCatalog.put(new ItemIdentifier(3),new ItemDTO("Soap", 18, "12%","Don't eat"));
    	}
}


