package se.kth.iv1350.pointofsale.model;

import java.util.*;

/**
	 * Represents an amount of money or amount of Items
	 */
public final class AmountOfCash {
	    private final int amount;

	    /**
	     * Creates a new instance, representing the amount 0.
	     */
	    public AmountOfCash() {
	        this(0);
	    }

	    /**
	     * Subtracts the specified <code>Amount</code> from this object and returns
	     * an <code>Amount</code> instance with the result. The operation will
	     * overflow if the result is smaller than <code>Integer.MIN_VALUE</code>.
	     *
	     * @param other The <code>Amount</code> to subtract.
	     * @return The result of the subtraction.
	     */
	    public AmountOfCash minus(AmountOfCash other) {
	        return new AmountOfCash(amount - other.amount);
	    }
	    
	    /**
	     * Creates a new instance, representing the specified amount.
	     *
	     * @param amount The amount represented by the newly created instance.
	     */
	    public AmountOfCash(int amount) {
	        this.amount = amount;
	    }

	    /**
	     * Subtracts the specified <code>Amount</code> from this object and returns
	     * an <code>Amount</code> instance with the result. The operation will
	     * overflow if the result is smaller than <code>Integer.MIN_VALUE</code>.
	     *
	     * @param other The <code>Amount</code> to subtract.
	     * @return The result of the subtraction.
	     */
	    public AmountOfCash minus(AmountOfCash other) {
	        return new AmountOfCash(amount - other.amount);
	    }

	    /**
	     * Adds the specified <code>Amount</code> to this object and returns an
	     * <code>Amount</code> instance with the result. The operation will
	     * overflow if the result is larger than <code>Integer.MAX_VALUE</code>.
	     *
	     * @param other The <code>Amount</code> to add.
	     * @return The result of the addition.
	     */
	    public AmountOfCash plus(AmountOfCash other) {
	        return new AmountOfCash(amount + other.amount);
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
	        return amount == otherAmount.amount;
	    }

	    @Override
	    public String toString() {
	        return Integer.toString(amount);
	    }
}

