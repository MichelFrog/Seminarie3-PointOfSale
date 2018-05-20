package se.kth.iv1350.pointofsale.logger;

/*
 * Prints a message to console.
 */
public class ConsoleLogger implements Logger {


	/**********************************************************
	 * Implementation for Logger Interface. Prints a message
	 * to console with information about an exception.
	 * 
	 **********************************************************/
	@Override
	public void log(String message) {
		System.out.println(message);	
	}

}
