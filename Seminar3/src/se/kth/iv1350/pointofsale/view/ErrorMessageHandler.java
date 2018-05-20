package se.kth.iv1350.pointofsale.view;

import java.text.SimpleDateFormat;
import java.util.Date;
/*********************************************
 * Creates and shows error message after and 
 * exception has been caught to the users.
 *********************************************/
public class ErrorMessageHandler {



	/*********************************************
	 * Creates a message with information that shows when
	 * an error was thrown with an customizable message.
	 * 
	 * @param msg The message containing the error.
	 *********************************************/
	void printErrorMessage(String message) {
		StringBuilder exceptionToBeShowed = new StringBuilder();

		exceptionToBeShowed.append("Time: "+fetchCurrentTime());
		exceptionToBeShowed.append("\n");
		exceptionToBeShowed.append("ERROR: ");
		exceptionToBeShowed.append(message);
		exceptionToBeShowed.append("\n *********************");


		System.out.println(exceptionToBeShowed);	}

	/*********************************************
	 * Creates a string of the current time.
	 * 
	 * @return String the current time with 
	 * year, month, day, minutes, and seconds.
	 *********************************************/
	private String fetchCurrentTime() {
		String currentTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		return currentTime;
	}
}
