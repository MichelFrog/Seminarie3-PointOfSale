package se.kth.iv1350.pointofsale.integration;

/***********************************
 * Handles unchecked database errors.
 * **********************************/
public class DatabaseFailureException extends RuntimeException {
	
	/************************************
	 * Creates a new instance representing a condition that
	 * is described in the message. Some items may cause an
	 * exception to be thrown.
	 *
	 * @param msg Describing message for the error that occurred.
	 ***********************************/
	public DatabaseFailureException(String message) { 
		super(message);
	}
}
