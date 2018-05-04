package se.kth.iv1350.pointofsale.controller;

import se.kth.iv1350.pointofsale.integration.ExternalSystem;
import se.kth.iv1350.pointofsale.integration.Item;
import se.kth.iv1350.pointofsale.integration.ItemCatalog;
import se.kth.iv1350.pointofsale.model.ItemIdentifier;
import se.kth.iv1350.pointofsale.integration.RegistryCreator;
import se.kth.iv1350.pointofsale.model.*;


public class Controller {
	private Sale sale;
	private Item Item;
	private SaleInformation InformationToBeDisplayed;
	private ItemCatalog ItemList;
	
	/*
	 *  Creates an empty object that will be used for the current {@link Sale} 
	 *  Basic flow
	 */
	public void startNewSale() {
		sale = new Sale();
	}
	
	public Controller() {
	}
	/*
	 * TODO
	 */
	public void pay(AmountOfCash givenAmount) {
		
	}
	public Item findItemToAddToSale(ItemIdentifier ItemIdentifier) {
		ItemList.searchForItem(ItemIdentifier);
		return Item;
	}

    /**
     * Takes the item after its been verifies
     * Books the specified car. After calling this method, the car can not be
     * booked by any other customer. This method also permanently saves
     * information about the current rental.
     *
     * @param code entered by the cashier.
     */
    public SaleInformation addSingleItem(Item Item) {
    	InformationToBeDisplayed = sale.addItem(Item);
       
    		if(Item != null) {
        	return InformationToBeDisplayed;
        }
        return null;
    }
    
	
}