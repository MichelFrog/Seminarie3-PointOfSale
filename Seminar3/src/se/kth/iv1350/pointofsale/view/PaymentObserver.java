package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.model.TotalPriceDTO;

public interface PaymentObserver {

	/**
	 * Notified when queue number is updated.
	 */

	    /**
	     * Called when a new payment has been made.
	     *
	     * @param queueNo The new queue number.
	     */
	    void newPayment(TotalPriceDTO totalPrice);
}

