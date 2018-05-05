package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.controller.Controller;
import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;

import java.util.*;
public class View {
	
	ItemIdentifier ItemIdentifier1 = new ItemIdentifier(100);
	ItemIdentifier ItemIdentifier2 = new ItemIdentifier(200);
	ItemIdentifier ItemIdentifier3 = new ItemIdentifier(300);
	
	private Controller contr;
	private Item	       recentItem;
	private SaleInformation toBeDisplayed;
	
	public View(Controller contr) {
				
	this.contr = contr;
	
	}
	
	/*
	 * Sample of hard coded execution of the adding functionality for system.
	 * Presents the user with most recently added item, price and running total.
	 * 
	 */
	public void sampleAddingItem() {
		
		this.recentItem =    contr.findItemForSale(ItemIdentifier1);
		 if (ItemIdentifier1 == null) throw new NullPointerException("input1");
		this.toBeDisplayed = contr.addSingleItem(recentItem);
		System.out.println(toBeDisplayed.toString());
		
		this.recentItem =    contr.findItemForSale(ItemIdentifier2);
		 if (ItemIdentifier2 == null) throw new NullPointerException("input2");
		this.toBeDisplayed = contr.addSingleItem(recentItem);
		System.out.println(toBeDisplayed.toString());
		
		this.recentItem =    contr.findItemForSale(ItemIdentifier3);
		 if (ItemIdentifier3 == null) throw new NullPointerException("input2");
		this.toBeDisplayed = contr.addSingleItem(recentItem);
		System.out.println(toBeDisplayed.toString());
	}
	
	/*
	 * Sample of hard coded execution of the adding functionality for system.
	 * Presents the user with most recently added item, price and running total.
	 * 
	 */
	public void samplePayment() {
		
		
		
		
	}

	

	

}
