package se.kth.iv1350.pointofsale.model;


/**
	 * Represents an amount of money or amount of Items
	 */
public final class AmountOfCash {
	    private  double amountOfCash = 0;

	    /**
	     * Constructor for AmountOfCash
	     */
	    public AmountOfCash() {
	    }

	    /**
	     * Creates new amount of cash after subtracting the previous
	     * <code>AmountOfCash</code> with another one.
	     *
	     * @param other The <code>AmountOfCash</code> to subtract.
	     * @return The result after subtraction
	     */
	    public AmountOfCash subtract(AmountOfCash other) {
	        return new AmountOfCash(amountOfCash - other.amountOfCash);
	    }
	    
	    /**
	     * Creates a new instance, representing the specified amount.
	     *
	     * @param amount The amount represented by the newly created instance.
	     */
	    public AmountOfCash(double amountOfCash) {
	        this.amountOfCash = amountOfCash;
	    }

	    /**
	     * Adds on a new <code>AmountOfCash</code> to the current <code>AmountOfCash</code>
	     * and creates a new instance of <code>AmountOfCash</code> with greater value.
	     *
	     * @param other amount to add on to current amount of cash
	     * @return The result after the addition.
	     */
	    public AmountOfCash plus(AmountOfCash other) {
	        return new AmountOfCash(amountOfCash + other.amountOfCash);
	    }

	    /**
	     * Two <code>Amount</code>s are equal if they represent the same amount.
	     *
	     * @param other The <code>Amount</code> to compare with this amount.
	     * @return <code>true</code> if the specified amount is equal to this
	     *         amount, <code>false</code> if it is not.
	     */
	    @Override
	    public boolean equals(Object other) {
	        if (other == null || !(other instanceof AmountOfCash)) {
	            return false;
	        }
	        AmountOfCash otherAmount = (AmountOfCash) other;
	        return amountOfCash == otherAmount.amountOfCash;
	    }

	    @Override
	    public String toString() {
	        return Double.toString(amountOfCash);
	    }
}

