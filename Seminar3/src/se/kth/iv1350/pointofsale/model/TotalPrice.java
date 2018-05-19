package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

public class TotalPrice {

	private  AmountOfCash price;
	private double tax;

	/**
	 *
	 * @param finalSaleInfo
	 */

	public TotalPrice(SaleInformation finalSaleInfo) {
		price = finalSaleInfo.getRunningTotal();
		tax = 1.12;
		addTax();
	}
	/*
	 * adds tax to totalPrice.
	 */
	private void addTax() {
		price.updateAmount(price.getAmount()*tax);
	}

	/*
	 * Getter for totalPrice
	 */
	public AmountOfCash getPrice() {
		return price;
	}
}
