package se.kth.iv1350.pointofsale.model;

/***********************************
 * Interface that is used to implement 
 * observer classes.
 ***********************************/
public interface PaymentObserver {

	/************************************
	 * Called when a new payment has been made.
	 *
	 * @param queueNo The new queue number.
	 ***********************************/
	void newPayment(TotalPrice totalPrice);
}

