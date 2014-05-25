package com.brillio.www.LogReport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.brillio.www.properties.GlobalProperties;

public class Communique {
	
	public static class log{
		
		/**
		 * This function will initialize the folders and files used in the execution
		 * @author krishna kishore g
		 * 
		 */
		public static void _init(){
			try{
				String RunId = GlobalProperties.items.getRunID();
				String wd = GlobalProperties.items.getWorkingDirectory();
				String logFolder = wd+"log", TempFolder = wd+"temp", ResultFolder = wd+"result";
				String RunIDinResult = ResultFolder + "/" + RunId + "/";
				String LogFile = logFolder + "/Log_" + RunId + ".txt";
				File log = new File(logFolder);
				File temp = new File(TempFolder);
				File result = new File(ResultFolder);
				File runresult = new File(RunIDinResult);
				File _logFile = new File(LogFile);
				if(!log.exists()){
					log.mkdir();
				}
				if(!temp.exists()){
					temp.mkdir();
					GlobalProperties.items.setTempFolder(TempFolder+"/");
				}else{
					File[] tFiles = temp.listFiles();
					for(File tf : tFiles){
						tf.delete();
					}
				}
				if(!result.exists()){
					result.mkdir();
				}
				if(!runresult.exists()){
					runresult.mkdir();
					GlobalProperties.items.setRunIDResultFolder(RunIDinResult);
				}
				if(!_logFile.exists()){
					_logFile.createNewFile();
					GlobalProperties.items.setLogFileAbsPath(LogFile);
				}
			}
			catch(Exception ex){
				System.out.println("Exception in Communique.log._init; Exception message = " + ex.getMessage());
			}
		}	
	
		
		public static void LogWritter(String Status, String Message){
			String msgFormat = "", methodname = "", MethodTrail = "", consoleFormat = "";
			try{
				StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
				methodname = stacktrace[2].getClassName() + "." + stacktrace[2].getMethodName();
				for(StackTraceElement stack:stacktrace){
					MethodTrail = stack.getClassName() + "." + stack.getMethodName() + "(" + stack.getLineNumber() + ")" + "->" + MethodTrail;
				}
				Date dNow = new Date( );
				SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
				switch (Status.toLowerCase().trim()) {
				case "pass":
					msgFormat = "|" + ft.format(dNow) + "|PASSED|" + Message + "|" + methodname + "|" + MethodTrail + "|";
					consoleFormat = "::-:: " + ft.format(dNow) + " ~*~ PASSED ~*~ " + Message + " ~*~ " + methodname + " ~*~";
					break;
				case "fail":
					msgFormat = "|" + ft.format(dNow) + "|FAILED|" + Message + "|" + methodname + "|" + MethodTrail + "|";
					consoleFormat = "::-:: " + ft.format(dNow) + " ~*~ FAILED ~*~ " + Message + " ~*~ " + methodname + " ~*~";
					break;
				case "warning":
					msgFormat = "|" + ft.format(dNow) + "|WARNING|" + Message + "|" + methodname + "|" + MethodTrail + "|";
					consoleFormat = "::-:: " + ft.format(dNow) + " ~*~ WARNING ~*~ " + Message + " ~*~ " + methodname + " ~*~";
					break;
				case "done":
					msgFormat = "|" + ft.format(dNow) + "|INFO|" + Message + "|" + methodname + "|" + MethodTrail + "|";
					consoleFormat = "::-:: " + ft.format(dNow) + " ~*~ INFO ~*~ " + Message + " ~*~ " + methodname + " ~*~";
					break;
				default:
					msgFormat = "|" + ft.format(dNow) + "|" + Status + "|" + Message + "|" + methodname + "|" + MethodTrail + "|";
					consoleFormat = "::-:: " + ft.format(dNow) + " ~*~ " + Status + " ~*~ " + Message + " ~*~ " + methodname + " ~*~";
					break;
				}
				System.out.println(consoleFormat);
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(GlobalProperties.items.getLogFileAbsPath(), true)));
				out.println(msgFormat);
				out.close();
			}
			catch(Exception ex){
				System.out.println("Exception in Communique.log.LogWritter; Exception message = " + ex.getMessage());
			}
		}
		
	}
}
