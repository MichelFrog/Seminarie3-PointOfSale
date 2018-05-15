package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

import java.time.LocalDateTime;
import java.util.*;

/*******************************
 *@author Michel
 * 
 ******************************/
public class SaleDTO {

	private final LocalDateTime saleTime;

	private final AmountOfCash runningTotal;

	private final Item lastSoldItem;

	private final ScannedItems scannedItems;

	/*******************************
	 *Constructor with parameters for the SaleDTO
	 * @param saleTime      The time of the sale.
	 * @param runningTotal  The current running total.
	 * @param lastSoldItem  The most recently sold item.
	 * @param scannedItems  All the scanned/sold items.
	 ******************************/
	public SaleDTO(AmountOfCash runningTotal, Item lastSoldItem, ScannedItems scannedItems) {
		this.saleTime = LocalDateTime.now();
		this.runningTotal = runningTotal;
		this.lastSoldItem = lastSoldItem;
		this.scannedItems = scannedItems;
	}

	/**********************
	 *Getter for the current sale time.
	 *
	 * @return saleTime Time of the sale.
	 **********************/
	public LocalDateTime getTimeOfSale() {
		return saleTime;
	}

	/***********************
	 * Getter for running total
	 * @return the current amount of cash.
	 **********************/
	public AmountOfCash getRunningTotal() {
		return runningTotal;
	}

	/***********************
	 *Getter for LastSoldItem
	 * @return the last item scanned.
	 **********************/
	public Item getLastSoldItem() {
		return lastSoldItem;
	}

	/***********************
	 *Getter for ScannedItems
	 *
	 * @return scannedItems Returns the list of sold items.
	 **********************/
	public ScannedItems getScannedItems() {
		return scannedItems;
	}

	/***********************
	 *Creates a String text that can be used by View to print out the current SaleDTO
	 *
	 * @return saleInfo String representation of the SaleDTO
	 **********************/
	public String toString(){
		String saleInfo = "Running Total: " + runningTotal.toString() +"\n Name of item: " 
				+ lastSoldItem.getItemName().toString() +"\n Price: " + lastSoldItem.getPrice();
		return saleInfo;
	}
	/***********************
	 *Creates a String text that can be used by View to print out the current SaleDTO
	 *
	 * @return saleInfo String representation of the SaleDTO
	 **********************/
	public String finalPriceIs(){
		String saleInfo = "Total price is: " + runningTotal.toString(); 
		return saleInfo;
	}


}