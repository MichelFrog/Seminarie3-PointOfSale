package se.kth.iv1350.pointofsale.integration;

import java.util.HashMap;

import se.kth.iv1350.pointofsale.model.ItemIdentifier;
/***********************************
 * Allows the <code>ItemCatalog</code> to find closest matches within the
 * database if item is not found.
 ***********************************/
public class ClosestMatch implements ItemFinder {
	private int codeOfSearchedItem;
	private int one = 1;
	ItemIdentifier itemBeforeSearchedItem;
	ItemIdentifier itemAfterSearchedItem;
	Item closestMatchedItem;


	public ClosestMatch() {
		ItemCatalog.getCatalogInstance().addItems();
	}
	/*********************************************************
	 * If item is not found the algorithm find the closest match
	 * which allows the client to try other options.
	 * 
	 * @param itemIdentifier		The code entered by the user. Stored as an object to allow
	 * 							HashMap manipulation
	 * 
	 * @return 					Returns an object with all information of 
	 * 							the items to the system and user.
	 *********************************************************/
	@Override
	public Item lookForItem(ItemIdentifier itemIdentifier) throws NonExistingItemException, 
	DatabaseFailureException {

		this.codeOfSearchedItem = itemIdentifier.getItemId();
		this.itemBeforeSearchedItem = new ItemIdentifier(codeOfSearchedItem + one);
		this.itemAfterSearchedItem = new ItemIdentifier(codeOfSearchedItem - one);

		if (checkTheCatalogFor(itemBeforeSearchedItem)) {
			return this.closestMatchedItem = ItemCatalog.getItemList().get(itemBeforeSearchedItem);
		}
		if (checkTheCatalogFor(itemAfterSearchedItem)) {
			return this.closestMatchedItem = ItemCatalog.getItemList().get(itemAfterSearchedItem);
		}

		return null;
	}
	/*********************************************************************
	 * Used to check <code>ItemCatalog</code> HashMap if there are any
	 * Item that contains certain Key. Make the code more clear
	 * for reading.
	 *********************************************************************/
	public boolean checkTheCatalogFor(ItemIdentifier itemIdentifier) {
		return ItemCatalog.getItemList().containsKey(itemIdentifier);	
	}

}
