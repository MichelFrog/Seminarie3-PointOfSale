package se.kth.iv1350.pointofsale.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
/**********************************
 * Managing the process of logging
 **********************************/
public class LogManager {
	//Name of file that is created.
	private static final String FILE_LOG_NAME = "pointofsale-log.txt";

	private PrintWriter logFile;
	/***********************************
	 * Creates a new instance of <code>PrinterWriter</code> used to log
	 * a message to a file.
	 ***********************************/
	public LogManager() throws IOException { 
		logFile = new PrintWriter(new FileWriter(FILE_LOG_NAME), true);
	}
	/***********************************
	 * Creates a message for an exception with item and message.
	 * Message saved to log and stack trace is printed.
	 * 
	 * @Param exception The exception to be logged.
	 ***********************************/
	public void logException(Exception exception) {
		StringBuilder exceptionToBeLogged = new StringBuilder();

		exceptionToBeLogged.append("Time thrown: "+fetchCurrentTime());
		exceptionToBeLogged.append("\n");
		exceptionToBeLogged.append(exception.getMessage());
		logFile.println(exceptionToBeLogged);
		exception.printStackTrace(logFile);
	}

	/***********************************
	 * Used to fetch time that is used for logging exception
	 * and providing a more detailed message.
	 ***********************************/
	private String fetchCurrentTime() {
		String currentTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		return currentTime;
	}
}
