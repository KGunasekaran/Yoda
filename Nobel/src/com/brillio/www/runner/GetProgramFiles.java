package com.brillio.www.runner;
import java.io.*;
import java.util.ArrayList;

import com.brillio.www.properties.GlobalProperties;

/**
 * this class will hold all the class that are to be used to parse
 * test, test collction & composit test collecion files
 * @author krishna kishore g krishnakg@brillio
 *
 */
public class GetProgramFiles {

	private ArrayList<String> test = new ArrayList<String>(); 
	private ArrayList<String> tc = new ArrayList<String>();
	private ArrayList<String> ctc = new ArrayList<String>();
	
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
			
		}
		catch(Exception ex){
			System.out.println("Exception in GetProgramFiles.GetProgramFiles; Message = " + ex.getMessage());
		}
	}
	
}
