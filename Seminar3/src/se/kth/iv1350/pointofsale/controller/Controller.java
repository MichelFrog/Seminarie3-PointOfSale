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
	private RegistryCreator      regCreator;
	
	 private AmountOfCash startingBalance = new AmountOfCash(2000);
	/**********************************************
	 *  Creates an empty object that will be used for the current {@link Sale} 
	 *  Basic flow
	 **********************************************/
	public void startNewSale(CashRegister RegistercashRegister) {
		sale = new Sale(cashRegister);
	}
	
	/*************************************************
	 * Constructor that initialize all the field variables and starts a new sale
	 * 
	 * @param regCreator Used to get the ItemCatalog and sending info to ExternalSystem
	 * @param printer Used for printing receipt
	 *************************************************/
    public Controller(RegistryCreator regCreator, Printer printer) {
        this.cashRegister = new CashRegister(startingBalance);
    		startNewSale(cashRegister);
        this.itemList = regCreator.getItemCatalog();
        this.printer = printer;
        this.saleInfo = new SaleInformation();
        totalPrice = new TotalPrice(saleInfo);
        this.regCreator = regCreator;
    }

    /**********************************************
     * Searches the ItemCatalog to check whether or not the item actually exists. 
     * 
     * If it exist:
     * @return Item returns the found item from the register
     * If it doesn't:
     * @return null return null if the item is non-existing
     **********************************************/
	public Item findItemForSale(ItemIdentifier ItemIdentifier) {
		if(itemList.searchForItem(ItemIdentifier) == null) {
			return null;}
		return this.item = itemList.searchForItem(ItemIdentifier);
	}
	
	public TotalPriceDTO finalizeSale() {
		return sale.finalizeSale();
	}
 
    /***********************************************
     * Takes the item after its been verifies and adds 
     * it through sale to SaleInformation.
     *
     * @param code entered by the cashier.
     **********************************************/ 
    public SaleDTO addSingleItem(ItemIdentifier item) {
    	
    		if(findItemForSale(item) == null) {
    			return null;
        }
    		return sale.addItem(findItemForSale(item));    
    	}
    
    /**********************************************
    *Calculates the amount of change to be given back.
    *Creates a new SaleDTO with the final SaleDTO with all the
    *information of the purchase. Creates a new receipt with necessary information.
    *
    * @param paidAmount The amount of cash given by the customer
    * @return change The amount of change after the pay.
    **********************************************/
   public AmountOfCash pay(AmountOfCash givenAmount) {
	   AmountOfCash change = sale.pay(givenAmount);
	   SaleDTO finalSaleInformation = sale.getSaleData();
	   receipt = new Receipt(finalSaleInformation, change, givenAmount);
	   
	   regCreator.getExternalSystem().updateAccountingSystem(finalSaleInformation);
	   regCreator.getExternalSystem().updateInventorySystem(finalSaleInformation);
	   printer.printReceipt(receipt);
	   
       return change;
   	}

}