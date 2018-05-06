package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.controller.Controller;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;
public class View {
	
	ItemIdentifier ItemIdentifier1 = new ItemIdentifier(100);
	ItemIdentifier ItemIdentifier2 = new ItemIdentifier(200);
	ItemIdentifier ItemIdentifier3 = new ItemIdentifier(300);
	
	private Controller 		contr;
	private Item	      	    recentItem;
	private SaleDTO 			toBeDisplayed;
	private AmountOfCash		givenAmount;
	
	public View(Controller contr) {
				
	this.contr = contr;
	 
	}
	
	/*******************************************************************************************
	 * Sample of hard coded execution of the adding functionality for system.
	 * Presents the user with most recently added item, price and running total.
	 * 
	 *******************************************************************************************/
	public void sampleAddingItemsAndPayment() {
		
		this.recentItem =    contr.findItemForSale(ItemIdentifier1);
		 if (ItemIdentifier1 == null) throw new NullPointerException("input1");
		this.toBeDisplayed = contr.addSingleItem(ItemIdentifier1);
		System.out.println(toBeDisplayed.toString());
		
		this.recentItem =    contr.findItemForSale(ItemIdentifier2);
		 if (ItemIdentifier2 == null) throw new NullPointerException("input2");
		this.toBeDisplayed = contr.addSingleItem(ItemIdentifier2);
		System.out.println(toBeDisplayed.toString());
		
		this.recentItem =    contr.findItemForSale(ItemIdentifier3);
		 if (ItemIdentifier3 == null) throw new NullPointerException("input3");
		this.toBeDisplayed = contr.addSingleItem(ItemIdentifier3);
		System.out.println(toBeDisplayed.toString());
		System.out.println("----------------------");
		TotalPriceDTO total = contr.finalizeSale();
		System.out.println("Your total is: " + total);
		
        AmountOfCash givenAmount = new AmountOfCash(1500);
        
        System.out.println("You paid:" +givenAmount+ "\n"+ "Your change:" +contr.pay(givenAmount));
	}
	

}
