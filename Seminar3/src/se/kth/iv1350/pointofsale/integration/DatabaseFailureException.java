package se.kth.iv1350.pointofsale.integration;

/*
 * Handles database
 * 
 */
public class DatabaseFailureException extends RuntimeException {
	/**
	 * Creates a new instance representing a condition that
	 * is described in the msg.
	 *
	 * @param msg Describing message for the error that occurred.
	 */
	public DatabaseFailureException(String msg) { 
		super(msg);
	}
}
