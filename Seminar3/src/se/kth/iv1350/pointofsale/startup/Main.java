package se.kth.iv1350.pointofsale.startup;

import se.kth.iv1350.pointofsale.controller.*;
import se.kth.iv1350.pointofsale.view.*;

	/**
	 * Starts the point of sale application.
	 */
public class Main {
	    /**
	     * @param args The program does not take any command line parameters. 
	     */
	    public static void main(String[] args) {
	        Controller contr = new Controller();
	        
	        View view = new View(contr);
	        
	        view.sampleAddingItem();
	    }

}
