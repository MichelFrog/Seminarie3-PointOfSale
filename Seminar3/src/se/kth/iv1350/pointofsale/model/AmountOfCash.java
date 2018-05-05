package se.kth.iv1350.pointofsale.model;


	/**************************
	 * Represents an amount of money or amount of Items
	 *************************/
public final class AmountOfCash {
	    private  double amountOfCash;

	    /**************************
	     * Constructor for AmountOfCash, amountOfCash set as zero.
	     *************************/
	    public AmountOfCash() {
	        this.amountOfCash = 0;
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
	    
	    /*************************************************
	     * Performs addition with another instance of <code>AmountOfCash</code>
	     * and the current <code>AmountOfCash</code> within the class.
	     *
	     * @param other amount to add on to current amount of cash
	     * @return The result after the addition.
	     *************************************************/
	    public AmountOfCash plus(AmountOfCash other) {
	        return new AmountOfCash(amountOfCash + other.amountOfCash);
	    }	  
	    
	    /*************************************************
	     * Performs addition with a double varaible
	     * and the current <code>AmountOfCash</code> within the class.
	     *
	     * @param other amount to add on to current amount of cash
	     * @return The result after the addition.
	     *************************************************/
	    public AmountOfCash add(double other) {
	        return new AmountOfCash(amountOfCash + other);
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

