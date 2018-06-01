package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.model.ItemIdentifier;
/*
 * The standard of which all items are searched for within
 * the ItemCatalog. Implemented by ItemCatalog or any other
 * class that uses an algorithm for item.
 */
public interface ItemFinder {

	/*********************************************************
	 * The code is searched for in the database to find an item that matches the code.
	 * If no match, throw a new exception.
	 * 
	 * @param itemIdentifier		The code entered by the user. Stored as an Object to allow
	 * 							HashMap manipulation
	 * 
	 * @return 					Returns an Object with all information of 
	 * 							the items to the system and user.
	 * 
	 * @throws NonExistingItemException if the items doesn't exist in the itemCatalog
	 * @throws DatabaseFailureException if an item or call caused the database fail.
	 *********************************************************/
	Item lookForItem(ItemIdentifier itemIdentifier)throws NonExistingItemException, 
															DatabaseFailureException;
}

