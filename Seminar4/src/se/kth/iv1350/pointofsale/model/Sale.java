package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.view.TotalRevenueView;

import java.util.*;
import java.time.LocalDateTime;
/********************************************************
 * Collects all information regarding a particular sale.
 *******************************************************/
public class Sale {
	/********************************************************
	 * Collects all information regarding a particular sale.
	 *******************************************************/ 
	private SaleInformation  saleInfo;
	private Item             newlyAddedItem;
	private AmountOfCash		runningTotal;
	private CashRegister cashRegister; 
	private TotalPrice 	totalPrice;
	private ScannedItems scannedItems;
	

	private List<PaymentObserver> paymentObservers =	new ArrayList<>();
	/***************************************************************
	 * Creates a new instance, and records the time it was created. 
	 * This will be the time recorded on the receipt.
	 ***************************************************************/
	public Sale(CashRegister cashRegister) { 
		this.saleInfo = new SaleInformation();
		this.runningTotal = new AmountOfCash();
		this.newlyAddedItem = new Item();
		this.scannedItems = new ScannedItems();
		totalPrice = new TotalPrice(saleInfo);
		this.cashRegister = cashRegister;
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
	 * Used to pay for the sale and update new revenue gained.
	 * 
	 * @param givenAmount the amount of cash given by customer
	 * @return AmountOfCash change is returned as an AmountOfCash
	 **************************************/
	public AmountOfCash pay(AmountOfCash givenAmount) {
		notifyObservers();
		return cashRegister.registerPayment(givenAmount, totalPrice);
	}
	


	/***************************************
	 * A new TotalPriceDTO is created to present the final 
	 * total sum that is used for the last payment.
	 * @return TotalPriceDTO contains final total price.
	 **************************************/
	public TotalPriceDTO finalizeSale() {
		return new TotalPriceDTO(totalPrice);
	}

	/******************************
	 * Gets the current saleInformation
	 *******************************/
	public SaleInformation getSaleInformation(){
		return saleInfo;
	}

	/******************************
	 * Gets the current scanned item.
	 *******************************/
	public Item getScannedItem() {
		return newlyAddedItem;
	}

	/******************************
	 * Gets the current running total.
	 *******************************/
	public AmountOfCash getSaleIntoRunningTotal() {
		return runningTotal;
	}

	/*******************************
	 * Creates and returns a new SaleDTO.
	 *
	 * @return SaleDTO get the current saleinformation.
	 *******************************/
	public SaleDTO getSaleData() {
		return saleInfo.getSaleInformation();
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
	
	/***************************************
	 * Updates the observer list with the revenue 
	 * from the sale.
	 * @Param observed the observer to be added.
	 ***************************************/
	public void addPaymentObserver(PaymentObserver obs) { 
		paymentObservers.add(obs);
	}
	
	/***************************************
	 * Used to update any change of the state of new payments
	 * that has been made.
	 ***************************************/	
	private void notifyObservers() {
		for (PaymentObserver observed : paymentObservers) {
			observed.newPayment(totalPrice);
		}
	}

}
