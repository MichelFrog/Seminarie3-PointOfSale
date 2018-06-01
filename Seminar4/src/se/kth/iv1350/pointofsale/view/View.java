package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.controller.Controller;
import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.logger.*;

import java.io.IOException;
import java.util.*;
public class View {

	ItemIdentifier ItemIdentifier1 = new ItemIdentifier(100);
	ItemIdentifier ItemIdentifier2 = new ItemIdentifier(102);
	ItemIdentifier ItemIdentifier3 = new ItemIdentifier(101);

	private ErrorMessageHandler errorMessage = new ErrorMessageHandler();

	private Controller 		contr;
	private Item	      	    recentlyScannedItem;
	private SaleDTO 			toBeDisplayed;
	private AmountOfCash		givenAmount;
	private Sale				sale;
	private LogManager 		logger;


	public View(Controller contr) {
		ItemCatalog.getCatalogInstance().addItems();
		contr.addObserver(new TotalRevenueView());
		try {
			this.logger = new LogManager();
		}catch(IOException e){
			e.printStackTrace();
		}
		this.contr = contr;

	}

	/*******************************************************************************************
	 * Sample of hard coded execution of the adding functionality for system.
	 * Presents the user with most recently added item, price and running total.
	 * 
	 * @throws NonExistingItemException If searched item isn't found.
	 * @throws DatabaseFailureException If a database failure occur during search
	 * @throws ItemCatalogException If any of the other exceptions fail to catch.
	 * 
	 *******************************************************************************************/
	public void sampleAddingItemsAndPayment() {

		try {
			this.recentlyScannedItem =    contr.findItemForSale(ItemIdentifier1);
			this.toBeDisplayed = contr.addSingleItem(ItemIdentifier1);

			System.out.println(toBeDisplayed.toString());
			System.out.println("----------------------");
		} catch (NonExistingItemException e) {
			constructException("The item you tried to add to the cart: " + e.getItemIdentifierThatDoesntExist() +
					", doesn't exist." + " Please try another itemID.", e);
		} catch (DatabaseFailureException e) { 
			constructException("Database has failed find item "+ ItemIdentifier1.getItemId() +
					", try another item instead.", e);
		} catch (ItemCatalogException e) {
			constructException("Failed to add item to basket. Try again.",e);
		}


		try {
			this.recentlyScannedItem =    contr.findItemForSale(ItemIdentifier2);
			this.toBeDisplayed = contr.addSingleItem(ItemIdentifier2);

			System.out.println(toBeDisplayed.toString());
			System.out.println("----------------------");
		} catch (NonExistingItemException e) {
			constructException("The item you tried to add to the cart: " + e.getItemIdentifierThatDoesntExist() +
					", doesn't exist." + " Please try another itemID.", e);
		} catch (DatabaseFailureException e) { 
			constructException("Database has failed find item "+ ItemIdentifier2.getItemId() +
					", try another item instead.", e);
		}
		catch (ItemCatalogException e) {
			constructException("Failed to add item to basket. Try again.",e);
		}


		try {
			this.recentlyScannedItem =    contr.findItemForSale(ItemIdentifier3);
			this.toBeDisplayed = contr.addSingleItem(ItemIdentifier3);

			System.out.println(toBeDisplayed.toString());
			System.out.println("----------------------"+ "\n");
		} catch (NonExistingItemException e) {
			constructException("The item you tried to add to the cart: " + e.getItemIdentifierThatDoesntExist() +
					", doesn't exist." + " Please try another itemID.", e);
		} catch (DatabaseFailureException e) { 
			constructException("Database has failed find item " + ItemIdentifier3.getItemId() + 
					", try another item instead.", e);
		}
		catch (ItemCatalogException e) {
			constructException("Failed to add item to basket. Try again.",e);
		}


		TotalPriceDTO total = contr.finalizeSale();

		AmountOfCash givenAmount = new AmountOfCash(1500);

		System.out.println("Your total is: " + total);
		System.out.println("You paid:" +givenAmount+ "\n"+ "Your change:" +contr.pay(givenAmount));

	}
	/************************
	 * Make the the code less messy.
	 ************************/
	private void constructException(String userMessage, Exception e) { 
		errorMessage.printErrorMessage(userMessage); 
		logger.logException(e);
		System.out.println("");
	}
	

}
