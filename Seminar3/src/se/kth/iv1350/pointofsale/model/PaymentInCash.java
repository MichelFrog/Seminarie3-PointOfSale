package se.kth.iv1350.pointofsale.model;

public class PaymentInCash {
    private AmountOfCash paidAmountOfCash;
    private AmountOfCash totalCost;
    
    
    /*
     * Constructor that creates a new instance with the amount
     * of cC
     * 
     */
    public PaymentInCash(AmountOfCash givenAmount) {
        this.paidAmountOfCash = givenAmount;
    }
    
}
