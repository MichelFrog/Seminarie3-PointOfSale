package se.kth.iv1350.pointofsale.model;


	/**************************
	 * Represents an amount of money or amount of Items
	 *************************/
public final class AmountOfCash {
	    private  double amountOfCash;
	    private double finalAmount;

	    /**************************
	     * Constructor for AmountOfCash, amountOfCash set as zero.
	     *************************/
	    public AmountOfCash() {
	        this.amountOfCash = 0;
	    }
	    
	    /**************************
	     * Updates the field variables with a new desired amount
	     *************************/
	    public void updateAmount(double newAmount) {
	        amountOfCash = newAmount;
	    }
	    
	    /**************************************************
	     * Creates a new instance, representing the specified amount.
	     *
	     * @param amount The amount represented by the newly created instance.
	     *************************************************/
	    public AmountOfCash(double amountOfCash) {
	        this.amountOfCash = amountOfCash;
	    }
	    
	    
	    /**************************************************
	     * Creates new amount of cash after subtracting the previous
	     * <code>AmountOfCash</code> with another one.
	     *
	     * @param other The <code>AmountOfCash</code> to subtract.
	     * @return The result after subtraction
	     *************************************************/
	    public AmountOfCash subtract(AmountOfCash other) {
	        return new AmountOfCash(amountOfCash - other.amountOfCash);
	    }
	    
	    
	    public double getAmount() {
	        return amountOfCash;
	    }
	    
	    public void setAmount(AmountOfCash other) {
	    		this.amountOfCash = other.getAmount();
	    }
	    
	    public double getFinalAmount() {
	        return finalAmount;
	    }
	    
	    public void setFinalAmount(AmountOfCash totalPrice) {
    			this.finalAmount = totalPrice.getAmount();
	    }
	    
	    /*************************************************
	     * Performs addition with a double variable
	     * and the current <code>AmountOfCash</code> within the class.
	     *
	     * @param other amount to add on to current amount of cash
	     * @return The result after the addition.
	     *************************************************/
	    public void add(AmountOfCash addition) {
	    		amountOfCash += addition.getAmount();
	    }
  
	    

	    /**************************************************************************
	     * Two <code>AmountOfCash</code>s are equal if they represent the same amount.
	     *
	     * @param other The <code>AmountOfCash</code> to compare with this amount.
	     * @return <code>true</code> if the specified amount is equal to this
	     *         amount, <code>false</code> if it is not.
	     *************************************************************************/
	    @Override
	    public boolean equals(Object o) {

	    	if (o == null) {
	    		return false;}
	    	
	    	if (!(o instanceof AmountOfCash)) {
	    		return false;}
	    	
	    	if (o == this)
	    		return true;
	    	AmountOfCash otherAmountOfCash = (AmountOfCash) o;

	    	return amountOfCash == otherAmountOfCash.amountOfCash;

	        }
	    
	    /*************************************************
	     * Creates a string that can be used to display AmountOfCash as string.
	     * 
	     * @return String that shows the amountOfCash.
	     *************************************************/
	    @Override
	    public String toString() {
	        return Double.toString(amountOfCash);
	    }
}

