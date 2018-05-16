package se.kth.iv1350.pointofsale.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class LogManager {

	private static final String FILE_LOG_NAME = "pointofsale-log.txt";

	
	private PrintWriter logFile;
	
	public LogManager() throws IOException { 
		logFile = new PrintWriter(new FileWriter(FILE_LOG_NAME), true);
	}
	
	public void logException(Exception exception) {
		StringBuilder exceptionToBeLogged = new StringBuilder();
		
		exceptionToBeLogged.append("Time thrown: "+fetchCurrentTime());
		exceptionToBeLogged.append("\n");
		exceptionToBeLogged.append(exception.getMessage());
		logFile.println(exceptionToBeLogged);
		exception.printStackTrace(logFile);
	}
	
	
	private String fetchCurrentTime() {
		String currentTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		return currentTime;
	}
}
