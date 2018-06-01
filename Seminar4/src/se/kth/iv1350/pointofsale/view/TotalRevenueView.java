package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.model.AmountOfCash;
import se.kth.iv1350.pointofsale.model.PaymentObserver;
import se.kth.iv1350.pointofsale.model.TotalPrice;
import se.kth.iv1350.pointofsale.model.TotalPriceDTO;
/***********************************
 * Observer that checks when the state of
 * TotalPrice is changed. Implements PaymentObserver
 ***********************************/
public class TotalRevenueView implements PaymentObserver {

	/***********************************
	 * Creates a message that shows the revenue from the sale
	 * 
	 * @param totalPrice The total amount of revenue from the sale.
	 ***********************************/
	@Override
	public void newPayment(TotalPrice totalPrice) {
		System.out.println("Total revenue form sale: " + totalPrice.toString());		
	}

}
