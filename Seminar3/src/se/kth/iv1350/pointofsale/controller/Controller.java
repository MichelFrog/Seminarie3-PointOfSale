package se.kth.iv1350.pointofsale.controller;

import se.kth.iv1350.pointofsale.integration.ExternalSystem;
import se.kth.iv1350.pointofsale.integration.Item;
import se.kth.iv1350.pointofsale.integration.ItemCatalog;
import se.kth.iv1350.pointofsale.integration.Printer;
import se.kth.iv1350.pointofsale.model.ItemIdentifier;
import se.kth.iv1350.pointofsale.integration.RegistryCreator;
import se.kth.iv1350.pointofsale.model.*;


public class Controller {
	private Sale sale;
	private Item item;
	private SaleInformation informationToBeDisplayed;
	private ItemCatalog itemList;
	private Printer printer;
	private CashRegister cashReg;
	
	/*
	 *  Creates an empty object that will be used for the current {@link Sale} 
	 *  Basic flow
	 */
	public void startNewSale() {
		sale = new Sale();
	}
	
    public Controller(RegistryCreator regCreator, Printer printer) {
        this.itemList = regCreator.getItemCatalog();
        this.printer = printer;
        this.cashReg = new CashRegister();
        // this.rentalRegistry = regCreator.getExternalSystem();
    }
	/*
	 * TODO
	 */
	public SaleInformation pay(double givenAmount) {
		
		
		return informationToBeDisplayed;
	}
	public Item findItemForSale(ItemIdentifier ItemIdentifier) {
		
		return this.item = itemList.searchForItem(ItemIdentifier);
	}

    /**
     * Takes the item after its been verifies
     * Books the specified car. After calling this method, the car can not be
     * booked by any other customer. This method also permanently saves
     * information about the current rental.
     *
     * @param code entered by the cashier.
     */
    public SaleInformation addSingleItem(Item item) {
    this.informationToBeDisplayed = sale.addItem(item);

    		if(item != null) {
        	return informationToBeDisplayed;
        }
        return null;
    }
    
	
}