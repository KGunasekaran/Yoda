package com.brillio.www.runner;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.brillio.www.properties.GlobalProperties;

/**
 * this class will hold all the class that are to be used to parse
 * test, test collction & composit test collecion files
 * @author krishna kishore g krishnakg@brillio
 *
 */
public class GetProgramFiles {

	private static HashMap<String, String> Programs = new HashMap<String, String>();
	private static HashMap<String, String> Collections = new HashMap<String, String>();
	
	/**
	 * this is the constructor method that will pre-process all the files in all the root and sub folders of
	 * program & collection
	 * @author krishna kishore g krishnakg@brillio.com
	 */
	public GetProgramFiles(){
		String tPath = "", ctcPath = "";
		try{
			tPath = GlobalProperties.items.getWorkingDirectory() + "program";
			ctcPath = GlobalProperties.items.getWorkingDirectory() + "collection";
			//first get the list of tests available
			Programs = listTests(tPath,0);
			Collections = listTests(ctcPath,0);
		}
		catch(Exception ex){
			System.out.println("Exception in GetProgramFiles.GetProgramFiles; Message = " + ex.getMessage());
		}
	}
	
	private static HashMap<String, String> listTests(String dirPath, int level) {
		HashMap<String, String> listoffiles = new HashMap<String,String>();
		try{
			
		    File dir = new File(dirPath);
		    File[] firstLevelFiles = dir.listFiles();
		    if (firstLevelFiles != null && firstLevelFiles.length > 0) {
		        for (File aFile : firstLevelFiles) {
		            if (!aFile.isDirectory()) {
		                listoffiles.put(aFile.getName().toLowerCase().trim(), aFile.getAbsolutePath().toLowerCase().trim());
		            }
		        }
		    }
		}
		catch(Exception ex){
			System.out.println("Error at GetProgramFiles.listTests " + ex.getMessage());
			listoffiles = null;
		}
		return listoffiles;
	}
	
	public static List<String> ProcessCollectionForTest(String CollectioName){
		ArrayList<String> TestNames = new ArrayList<String>();  
		try{
			if(!CollectioName.endsWith(".ctc")){
				CollectioName += ".ctc";
			}
			if(Collections.containsKey(CollectioName)){
				String FileName = Collections.get(CollectioName);
				ArrayList<String> fData = ReadFile(FileName);
				for(String fName : fData){
					String Tfile = Programs.get(fName);
					
				}
			}
			
		}catch(Exception ex){
			TestNames = null;
		}
		return TestNames;
	}
	
	
	public static ArrayList<String> ReadFile(String absPath) throws IOException{
		ArrayList<String> FileData = new ArrayList<String>();  
		String LineData = "";
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(absPath));
			while ((LineData = br.readLine()) != null) {
				FileData.add(LineData);
			}
		}catch(Exception ex){
			FileData = null;
		}
		finally{
			br.close();
		}
		return FileData;
	}
	
	public static void ReadTestFile(String TestName) throws IOException{
		ArrayList<String> setup = new ArrayList<String>();
		ArrayList<String> AllLines = new ArrayList<String>();
		HashMap<String, ArrayList<String>> mTestCase = new HashMap<String, ArrayList<String>>();
		BufferedReader br= null;
		String line = "";
		int SetUpLoc = 0, Counter = 0, descLoc = 0;
		ArrayList<Integer> tcLoc = new ArrayList<Integer>();
		try{
			br= new BufferedReader(new FileReader(TestName));
			while((line = br.readLine()) != null){
				Counter += 1;
				if(!line.trim().equals("")){
					AllLines.add(line);
					if(line.trim().toLowerCase().replace(" ", "").startsWith("testdescription")){
						descLoc = Counter;
					}
					else if(line.trim().toLowerCase().replace(" ", "").startsWith("setup")){
						SetUpLoc = Counter;
					}
					else if(line.trim().toLowerCase().replace(" ", "").startsWith("testcase")){
						tcLoc.add(Counter);
					}
				}
			}
			System.setProperty("testdescription", AllLines.get(descLoc).split(":")[1]);
			
			
		}catch(Exception ex){
			
		}
		finally{
			br.close();
		}
		
	}
}
