package se.kth.iv1350.pointofsale.controller;

import se.kth.iv1350.pointofsale.integration.ExternalSystem;
import se.kth.iv1350.pointofsale.integration.ItemDTO;
import se.kth.iv1350.pointofsale.model.ItemIdentifier;
import se.kth.iv1350.pointofsale.integration.RegistryCreator;
import se.kth.iv1350.pointofsale.model.*;


public class Controller {
	private Sale sale;
	private ItemDTO Item;
	private SaleInformation InformationToBeDisplayed;
	
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


    /**
     * System searches for the item and adds it to the SaleInformation
     * Books the specified car. After calling this method, the car can not be
     * booked by any other customer. This method also permanently saves
     * information about the current rental.
     *
     * @param code entered by the cashier.
     */
    public SaleInformation addSingleItem(ItemIdentifier ItemIdentifier) {
       Item = sale.addItem(ItemIdentifier);
        if(Item != null) {
        	sale.saveToSaleInformation(Item); //TODO
        }
        return InformationToBeDisplayed;
    }
	
}