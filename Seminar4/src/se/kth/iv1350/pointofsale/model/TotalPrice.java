package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

public class TotalPrice {

	private  AmountOfCash price;
	private double tax;

	/************************************************
	 * Constructor for TotalPrice
	 * 
	 * @param finalSaleInfo Contains the total price
	 ***********************************************/

	public TotalPrice(SaleInformation finalSaleInfo) {
		price = finalSaleInfo.getRunningTotal();
		tax = 1.12;
		addTax();
	}
	/************************
	 * Adds tax to totalPrice.
	 ************************/
	private void addTax() {
		price.updateAmount(price.getAmount()*tax);
	}

	/************************
	 * Getter for totalPrice
	 ************************/
	public AmountOfCash getPrice() {
		return price;
	}
	
	/************************
	 * Used to convert the price to string
	 * for printing.
	 ************************/
	public String toString(){
		return price.toString();
	}
}
