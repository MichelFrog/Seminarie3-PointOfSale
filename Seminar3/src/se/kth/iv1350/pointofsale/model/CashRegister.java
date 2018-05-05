package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

public class CashRegister {
	private double balance;
	private SaleInformation runnningTotalToBeChanged = new SaleInformation();
	   
	public void storePayment(double givenAmount){
		balance = balance.plus(payment.getTotalCost());
	}
	
	public double calculateRunningTotal(Item newlyAddedItem) {
		
	
	}
	/*
	 * @return: calculates the change after 
	 */
	public void getChange() {
	return givenAmount.minus(totalCost);
	}
}
