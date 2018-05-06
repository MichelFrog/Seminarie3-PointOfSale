package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.model.Receipt;

public class Printer {

    /*************************
     *Constructor for Printer. 
     *************************/
    public Printer() {
		
	}

    /***********************************************
     *Prints out the received receipt to the console.
     * @param recieptOfSale is the receipt of the recently finished sale.
     **********************************************/
    public void printReceipt(Receipt receiptOfSale) {
            System.out.println(receiptOfSale);
	}

}
