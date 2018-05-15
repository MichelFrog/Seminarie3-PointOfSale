package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

import java.util.*;

public class CashRegister {

	private AmountOfCash balance;

	/********************
	 *The current balance in the register.
	 * @param balance
	 ********************/
	public CashRegister(AmountOfCash balance) {
		this.balance = balance;
	}
	/****************************************
	 *Creates a new AmountOfCash that gets shows how much money the customer will
	 *receive after the purchase.
	 *
	 * @param givenAmount The amount received by the customer.
	 * @param totalPrice  The total price of the whole purchase
	 * 	 
	 * @return change Adds the what's left of the purchase to the
	 ***************************************/
	public AmountOfCash registerPayment(AmountOfCash givenAmount, TotalPrice totalPrice) {
		//if(null)
		AmountOfCash change = calculateChange(givenAmount, totalPrice);
		balance.add(change);
		return change;
	}

	/***************************************
	 * Calculates the change with the givenAmount and the totalPrice of the purchase.
	 * 
	 * @return change gets casted to AmountOfCash
	 ***************************************/
	private AmountOfCash calculateChange(AmountOfCash givenAmount, TotalPrice totalPrice) {
		//if(null)
		double change = givenAmount.getAmount() - totalPrice.getPrice().getAmount();
		return new AmountOfCash(change);
	}

}

