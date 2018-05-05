package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

public class CashRegister {
	 private AmountOfCash balance = new AmountOfCash();
	   
	public void storePayment(AmountOfCash givenAmount){
		balance = balance.plus(payment.getTotalCost());
	}
	
	public AmountOfCash getRunningTotal() {
	
	}
	/*
	 * @return: calculates the change after 
	 */
	public void getChange() {
	return givenAmount.minus(totalCost);
	}
}
