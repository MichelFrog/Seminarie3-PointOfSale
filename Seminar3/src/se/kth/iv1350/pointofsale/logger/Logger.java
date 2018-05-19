package se.kth.iv1350.pointofsale.logger;
/*
 * Standard for all loggers that stores a message
 * to desired area of the computer.
 */	
public interface Logger {
	    /**
	     * Implementation element used for printing a log message
	     * @param message The message to log to file or console.
	     */
	    public void log(String message);
	
}
