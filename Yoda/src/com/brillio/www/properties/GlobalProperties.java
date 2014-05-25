package com.brillio.www.properties;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is the Global Properties Class, this has static inner class which contains properties
 * @author krishna kishore g krishnakg@brillio.com
 *
 */
public class GlobalProperties {

	/**
	 * this is the items class that has basic property items used in the test
	 * @author krishna kishore g krishnakg@brillio.com
	 *
	 */
	public static class items{
		//This variable will hold the woking directory of this package
		private static String WorkingDirectory = "";
		public static String getWorkingDirectory(){ return WorkingDirectory; }
		public static void setWorkingDirectory(String _WorkingDirectory){WorkingDirectory = _WorkingDirectory;}
		private static String RunID = "";
		public static String getRunID(){return RunID;}
		public static void setRunID(String _RunID){ RunID = _RunID;}
		private static String RunUserName = "";
		public static String getRunUserName(){return RunUserName;}
		public static void setRunUserName(String _RunUserName){ RunUserName = _RunUserName;}
		private static String LogFileAbsPath = "";
		public static String getLogFileAbsPath(){return LogFileAbsPath;}
		public static void setLogFileAbsPath(String _LogFileAbsPath){ LogFileAbsPath = _LogFileAbsPath;}
		private static String RunIDResultFolder = "";
		public static String getRunIDResultFolder(){return RunIDResultFolder;}
		public static void setRunIDResultFolder(String _RunIDResultFolder){ RunIDResultFolder = _RunIDResultFolder;}
		private static String RunOS = "";
		public static String getRunOS(){return RunOS;}
		public static void setRunOS(String _RunOS){ RunOS = _RunOS;}
		private static String TempFolder = "";
		public static String getTempFolder(){return TempFolder;}
		public static void setTempFolder(String _TempFolder){ TempFolder = _TempFolder;}
	}
	
	/**
	 * this class will contain the list of scenario files, each file will contain n no of scenarios
	 * @author krishna kishore g krishnakg@brillio.com
	 *
	 */
	public static class ScenarioFile{
		
		private static ArrayList<String> ScenarioFiless = new ArrayList<String>();
		/**
		 * this method returns ArrayList<String> containing list of files of the scenarios
		 * @return ArrayList<String> ScenarioFiless
		 */
		public static ArrayList<String> getAllScenarios(){ return ScenarioFiless; }
		/**
		 * this method will add the specified file name to the ScenarioFiless property
		 * @param _Scenario
		 */
		public static void setScenario(String _Scenario){ ScenarioFiless.add(_Scenario); }
		public static String getSpecificScenario(int Index){return ScenarioFiless.get(Index);}
		
	}

	public static class TestEnvironment{
		private static HashMap<String,String> Environment = new HashMap<String,String>();
		public static void addToEnvironment(String Key, String Value){ Environment.put(Key, Value); }
		public static String getFromEnvironment(String Key){ return Environment.get(Key); }
		public static void SetEnvironment(HashMap<String,String> _Environment){Environment = _Environment;}
		public static HashMap<String,String> getAllEnvironment(){ return Environment; }
		public static void _init(){
			String configfile = items.getWorkingDirectory() + "config/test.config";
			
		}
	}
}
