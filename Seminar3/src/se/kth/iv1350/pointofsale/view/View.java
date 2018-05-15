package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.controller.Controller;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;
public class View {
	
	ItemIdentifier ItemIdentifier1 = new ItemIdentifier(100);
	ItemIdentifier ItemIdentifier2 = new ItemIdentifier(200);
	ItemIdentifier ItemIdentifier3 = new ItemIdentifier(0);
	
	private Controller 		contr;
	private Item	      	    recentlyScannedItem;
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
		
		try {
		this.recentlyScannedItem =    contr.findItemForSale(ItemIdentifier1);

		this.toBeDisplayed = contr.addSingleItem(ItemIdentifier1);
		System.out.println(toBeDisplayed.toString());
		System.out.println("----------------------");
		} catch (NonExistingItemException e) {
			e.printStackTrace();
		} catch (DatabaseFailureException e) { 
			e.printStackTrace();
		}

		
		try {
		this.recentlyScannedItem =    contr.findItemForSale(ItemIdentifier2);
		
		this.toBeDisplayed = contr.addSingleItem(ItemIdentifier2);
		System.out.println(toBeDisplayed.toString());
		System.out.println("----------------------");
		} catch (NonExistingItemException e) {
			e.printStackTrace();
		} catch (DatabaseFailureException e) { 
			e.printStackTrace();
		}
//		} catch (Exception exc) { 
//			exc.printStackTrace();
//		}
			
		try {
		this.recentlyScannedItem =    contr.findItemForSale(ItemIdentifier3);
		
		this.toBeDisplayed = contr.addSingleItem(ItemIdentifier3);
		System.out.println(toBeDisplayed.toString());
		System.out.println("----------------------");
		} catch (NonExistingItemException e) {
			e.printStackTrace();
		} catch (DatabaseFailureException e) { 
			e.printStackTrace();
		}
//		} catch (Exception exc) { 
//			exc.printStackTrace();
//		}
		
		
		TotalPriceDTO total = contr.finalizeSale();
		System.out.println("Your total is: " + total);
		
        AmountOfCash givenAmount = new AmountOfCash(1500);
        
        System.out.println("You paid:" +givenAmount+ "\n"+ "Your change:" +contr.pay(givenAmount));
	}
	

}
