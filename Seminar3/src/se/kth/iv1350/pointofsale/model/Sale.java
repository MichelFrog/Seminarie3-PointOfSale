package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;
import java.time.LocalDateTime;
/********************************************************
 * Collects all information regarding a particular sale.
 *******************************************************/
public class Sale {
	private Item             newlyAddedItem;
	//private ItemCatalog      listOfItems;
	private AmountOfCash		runningTotal;
	/********************************************************
	 * Collects all information regarding a particular sale.
	 *******************************************************/ 
	private SaleInformation  saleInfo;
   // private ScannedItems scannedItems;
    private CashRegister cashRegister; 
    private TotalPrice 	totalPrice;

    /***************************************************************
     * Creates a new instance, and records the time it was created. 
     * This will be the time recorded on the receipt.
     ***************************************************************/
    public Sale(CashRegister cashRegister) { 
    	this.saleInfo = new SaleInformation();
    	this.runningTotal = new AmountOfCash();
    	this.newlyAddedItem = new Item();
   // 	this.scannedItems = new ScannedItems();
    	this.cashRegister = cashRegister;
    	 totalPrice = new TotalPrice(saleInfo);
    }
    
    /**********************************************************************************
     * Updates the SaleInformation with all details from the item, which can be after
     * to get the SaleDTO with all the information. 
     * 
     * @return SaleDTO 	Used by View to printout all the information.
     **********************************************************************************/
    public SaleDTO addItem(Item item) {  
    		saleInfo.updateSale(item);
    
        return getSaleData();        
    }
    
    /***************************************
    * @param givenAmount
    * @return
    **************************************/
   public AmountOfCash pay(AmountOfCash givenAmount, TotalPrice totalPrice) {
	   
		return cashRegister.registerPayment(givenAmount, totalPrice);
   }
    /**********************************************************************************
     * Shows the Item that has been scanned as a text for the cashier.
     * NOT IN USE YET
     * @param NewlyAddedItem 	The item that has been just searched and 
     * 							added to the ScannedItems
     **********************************************************************************/
    	public void showAddedItem(Item newlyAddedItem) {
    		newlyAddedItem.toString();
    	}
    	
    public TotalPriceDTO finalizeSale() {
    		totalPrice = new TotalPrice(saleInfo);
    		return new TotalPriceDTO(totalPrice);
    	}
    	
    	/******************************
    	 * Gets the current saleInformation
    	 *******************************/
    	public SaleInformation getSaleInformation(){
    		return saleInfo;
    	}
    	
    public Item getScannedItem() {
    		return newlyAddedItem;
    }
    
    public AmountOfCash getSaleIntoRunningTotal() {
    		return runningTotal;
    }
    
    /**
    *
    * @return
    */
   public SaleDTO getSaleData() {
		return saleInfo.getSaleInformation();
}

}
