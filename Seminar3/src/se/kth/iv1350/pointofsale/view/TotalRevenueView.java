package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.model.AmountOfCash;
import se.kth.iv1350.pointofsale.model.TotalPriceDTO;

public class TotalRevenueView implements PaymentObserver {

	
	@Override
	public void newPayment(TotalPriceDTO totalPrice) {
		System.out.println("Total revenue form sale: " + totalPrice.toString());
		
	}

}
