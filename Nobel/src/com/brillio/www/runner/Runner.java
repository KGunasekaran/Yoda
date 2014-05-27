package com.brillio.www.runner;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.james.mime4j.field.datetime.DateTime;

import com.brillio.www.LogReport.Communique;
import com.brillio.www.properties.*;


/**
 * 
 * @author krishna kishore g - krishnakg@brillio.com
 *
 */
public class Runner {

	/**
	 * All Class defenition are done here and they are initilized in the main function
	 */
	
	
	/**
	 * This is the main entry point for the application, this function will get the file name 
	 * or component name or the 
	 * @param args
	 */
	public static void main(String[] args) {
		// create a thread and start a parallel execution from here		
		try{
			Date dNow = new Date( );
			SimpleDateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
			String RunID = String.valueOf(ft.format(dNow)) + String.valueOf(System.currentTimeMillis());
			GlobalProperties.items.setRunID(RunID);
			run();
			
		}
		catch(Exception ex){
			
		}

	}
	
	public static void run(){
		Date dNow = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
		try{
			// First initilize all the classes used
			_init();
			Communique.log.LogWritter("done", "Date & Time = " + ft.format(dNow));
			Communique.log.LogWritter("done", "Successfully initilized");
			Communique.log.LogWritter("done", "Run ID = " + GlobalProperties.items.getRunID());
			Communique.log.LogWritter("done", "Working Directory = " + GlobalProperties.items.getWorkingDirectory());
			Communique.log.LogWritter("done", "Result Directory = " +		GlobalProperties.items.getRunIDResultFolder());
			Communique.log.LogWritter("done", "Run Initiatet by = " + GlobalProperties.items.getRunUserName());
			Communique.log.LogWritter("done", "Operating System = " + GlobalProperties.items.getRunOS());
			Communique.log.LogWritter("done", "Looking for the configuration file in the working directory");
			String conf = System.getProperty("configfile");
			if(conf != null){
				GlobalProperties.TestEnvironment._init(conf);
			}
			else{
				GlobalProperties.TestEnvironment._init();
			}
			
		}
		catch(Exception ex){
			System.out.println("Exception in Runner.main; Message = " + ex.getMessage());
		}
	}
	
	
	
	public static void _init(){
		try{
			String eclipsewd = System.getProperty("user.dir");
		    String username = System.getProperty("user.name");
		    String osname = System.getProperty("os.name");
		    String osversion = System.getProperty("os.version");
		    String osarch = System.getProperty("os.arch");
		    String oWD = "";
		    if(eclipsewd.trim().equals("")){
		    	oWD = Runner.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		    }
		    else{
		    	oWD = eclipsewd + "/";
		    }
			System.out.println("Hi Welcome to Nobel...");
			System.out.println("...In God We Trust");
			String os = osname + "-(" + osversion + ")-(" + osarch + ")";
			GlobalProperties.items.setRunUserName(username);
			GlobalProperties.items.setWorkingDirectory(oWD);
		    GlobalProperties.items.setRunOS(os);
		    Communique.log._init();
		}
		catch(Exception ex){
			System.out.println("Exception in _init; Exception message = " + ex.getMessage());
		}
	}

}
