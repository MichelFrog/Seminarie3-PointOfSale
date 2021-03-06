package se.kth.iv1350.pointofsale.integration;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;
/*********************************************************
 * Singleton class that is used to store all items in
 * the database that the point of sale fetches items from.
 *********************************************************/
public class ItemCatalog implements ItemFinder {

	/*****************************
	 * Used for storing all the items in a database.
	 *****************************/
	private static final HashMap<ItemIdentifier, Item> itemCatalog = new HashMap<ItemIdentifier, Item>();

	private static final ItemCatalog ONLY_CATALOG_INSTANCE = new ItemCatalog();
	/*****************************
	 * Empty and private constructor to avoid having more than one
	 * instance of the singleton class.
	 *****************************/    
	private ItemCatalog() {}
	/*********************************************************
	 * The code is searched for in the database to find an item that matches the code.
	 * If no match, throw a new exception.
	 * 
	 * @param itemIdentifier		The code entered by the user. Stored as an Object to allow
	 * 							HashMap manipulation
	 * 
	 * @return 					Returns an Object with all information of 
	 * 							the items to the system and user.
	 * @throws NonExistingItemException if the items doesn't exist in the itemCatalog
	 * @throws DatabaseFailureException if an item or call caused the database fail.
	 *********************************************************/

	@Override
	public Item lookForItem(ItemIdentifier itemIdentifier) throws NonExistingItemException, 
																DatabaseFailureException  {

		if(itemIdentifier.getItemId() == 0){
			throw new DatabaseFailureException(
					"ERROR! Database failure, caused by: " + itemIdentifier.getItemId());
		}
		if (this.itemCatalog.containsKey(itemIdentifier)) {
			return this.itemCatalog.get(itemIdentifier); 
		}
		if(new ClosestMatch().lookForItem(itemIdentifier) != null) {
			return new ClosestMatch().lookForItem(itemIdentifier);
		}
		throw new NonExistingItemException(itemIdentifier);
	}


	/*****************************
	 * Adds new items to the <code>itemCatalog</code> ,HashMap.
	 * First of <code>itemCatalog</code>  @param input is for itemIdentifier
	 * Second of <code>itemCatalog</code>  @param input is for all parameter in the Item constructor.
	 * 
	 * ItemIdentifier itemCode, String itemName, int price,String tax, String description
	 *****************************/        
	public void addItems() {

		Item coconut = new Item(new ItemIdentifier(100), "Coconut", new AmountOfCash(10), "12%", "Origin: UK" );
		this.itemCatalog.put(coconut.getItemCode(),coconut);

		Item Water = new Item(new ItemIdentifier(101),"Bottled Water",new AmountOfCash(9), "12%", "BottledWaterCo");
		this.itemCatalog.put(Water.getItemCode(),Water);

		Item Soap = new Item(new ItemIdentifier(102), "Soap", new AmountOfCash(6), "12%","Don't eat");
		this.itemCatalog.put(Soap.getItemCode(),Soap);
	}
	/*
	 * Used to get the only instance of ItemCalog.
	 */
	public static ItemCatalog getCatalogInstance() {
		return ONLY_CATALOG_INSTANCE;
	}

	public static HashMap<ItemIdentifier, Item> getItemList(){
		return itemCatalog;
	}


}


