package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

public class PaymentInCash {
    private double givenAmount;
    private double totalCost;
    private SaleInformation SaleInfo;
    
    
    /*
     * Constructor that creates a new instance with the amount
     * of cC
     * 
     */
    public PaymentInCash(double givenAmount) {
        this.givenAmount = givenAmount;
    }
    
    public double calculateTotalCost(double givenAmount) {
    		return this.totalCost = (SaleInfo.getRunningTotal() - givenAmount);
    	
    } 
    
    public double getTotalCost() {
    		return totalCost;
    }
    
}
