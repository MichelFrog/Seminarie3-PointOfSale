package se.kth.iv1350.pointofsale.controller;

import se.kth.iv1350.pointofsale.integration.ExternalSystem;
import se.kth.iv1350.pointofsale.integration.Item;
import se.kth.iv1350.pointofsale.integration.ItemCatalog;
import se.kth.iv1350.pointofsale.integration.Printer;
import se.kth.iv1350.pointofsale.model.ItemIdentifier;
import se.kth.iv1350.pointofsale.integration.RegistryCreator;
import se.kth.iv1350.pointofsale.model.*;


public class Controller {
	private Sale 				sale;
	private Item 				item;
	private SaleInformation 		saleInfo;
	private ItemCatalog			itemList;
	private Printer 				printer;
	private Receipt			    receipt;
	private CashRegister			cashRegister;
	private TotalPrice			totalPrice;
	
	 private AmountOfCash startingBalance = new AmountOfCash(2000);
	/*
	 *  Creates an empty object that will be used for the current {@link Sale} 
	 *  Basic flow
	 */
	public void startNewSale(CashRegister RegistercashRegister) {
		sale = new Sale(cashRegister);
	}
	
    public Controller(RegistryCreator regCreator, Printer printer) {
        this.cashRegister = new CashRegister(startingBalance);
    		startNewSale(cashRegister);
        this.itemList = regCreator.getItemCatalog();
        this.printer = printer;
        totalPrice = new TotalPrice(saleInfo);
        this.saleInfo = new SaleInformation();
    }

    /*
     * Searches the ItemCatalog to check whether or not the item actually exists. 
     * If it exist:
     * @return Item returns the found item from the register
     * If it doesn't:
     * @return null return null if the item is non-existing
     */
	public Item findItemForSale(ItemIdentifier ItemIdentifier) {
		if(itemList.searchForItem(ItemIdentifier) == null) {
			return null;}
		return this.item = itemList.searchForItem(ItemIdentifier);
	}
	
	public TotalPriceDTO finalizeSale() {
		return sale.finalizeSale();
	}
 
    /**
     * Takes the item after its been verifies
     * Books the specified car. After calling this method, the car can not be
     * booked by any other customer. This method also permanently saves
     * information about the current rental.
     *
     * @param code entered by the cashier.
     */ 
    public SaleDTO addSingleItem(ItemIdentifier item) {
    	
    		if(findItemForSale(item) == null) {
    			return null;
        }
    		return sale.addItem(findItemForSale(item));    
    	}
    
    /**
    *
    * @param paidAmount
    * @return
    */
   public AmountOfCash pay(AmountOfCash givenAmount) {

       return cashRegister.registerPayment(givenAmount, totalPrice);

}
  // receipt = new Receipt(sale.getSaleData(), change, givenAmount);
    
	
}