package se.kth.iv1350.pointofsale.integration;

/*
 * Handles general database errors.
 * 
 */
public class DatabaseFailureException extends RuntimeException {
	
	/**
	 * Creates a new instance representing a condition that
	 * is described in the message.
	 *
	 * @param msg Describing message for the error that occurred.
	 */
	public DatabaseFailureException(String message) { 
		super(message);
	}
}
