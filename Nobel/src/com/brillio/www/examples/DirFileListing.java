package com.brillio.www.examples;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.collections.map.HashedMap;

public class DirFileListing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listDirectory("D:/Krishna Kishore/Project-Alpha/Repo/Yoda/Nobel/program",0);
	}
	
	public static HashMap<String, String> listDirectory(String dirPath, int level) {
		HashMap<String, String> listoffiles = new HashMap<String,String>();
		try{
			
		    File dir = new File(dirPath);
		    File[] firstLevelFiles = dir.listFiles();
		    if (firstLevelFiles != null && firstLevelFiles.length > 0) {
		        for (File aFile : firstLevelFiles) {
		            for (int i = 0; i < level; i++) {
		                System.out.print("\t");
		            }
		            if (!aFile.isDirectory()) {
		                System.out.println(aFile.getAbsolutePath()); //aFile.getName() + "-" +
		                System.out.println(aFile.getCanonicalPath());
		                listoffiles.put(aFile.getName(), aFile.getAbsolutePath());
		            }
		        }
		    }
		}
		catch(Exception ex){
			System.out.println("Error at listDirectory " + ex.getMessage());
			listoffiles = null;
		}
		return listoffiles;
	}

}
