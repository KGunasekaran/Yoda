package com.brillio.www.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	/**
	 * All the methods related to accessing MS Access is available in this class
	 * @author krishna kishore g krishnakg@brillio.com
	 */
	public static class MSAccess{
		
		public static String[][] QueryAccess(String Query){
			Connection conn = null;
			Statement sqlStatement = null;
			int ColCount = 0;
			String DBRValue = "";
	        String[][] RowCol = null;
			try{
				String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=myDB.mdb;";
				conn = DriverManager.getConnection(database, "", "");
				if(conn != null){
					sqlStatement = conn.createStatement();
					sqlStatement.execute(Query);
					ResultSet _recordSet = sqlStatement.getResultSet();
					ColCount = _recordSet.getMetaData().getColumnCount();
		            while((_recordSet != null) && (_recordSet.next()))
		            {
		                DBRValue += _recordSet.getRow();
	                    for (int LoopA = 1; LoopA <= ColCount; LoopA++){
	                 	   DBRValue += "`" + _recordSet.getString(LoopA);
	                    }
	                    DBRValue += "~";
		            }
		            String[] Rows = DBRValue.split("~");
	                String[] Col1 = Rows[0].split("`");
	                int RLen = Rows.length;
	                int CLen = Col1.length;
	                RowCol = new String[RLen][CLen];
	                for(int LoopB = 0; LoopB < RLen; LoopB++){
	              	  Col1 = Rows[LoopB].split("`");
	              	  for(int LoopC = 0; LoopC < CLen; LoopC++){
	              		  System.out.println(Col1[LoopC]);
	              		  RowCol[LoopB][LoopC] = Col1[LoopC];
	              	  }
	                }
				}
				else{
					System.out.println("Error in Connection to the DataBase DataBase.MSAccess.QueryAccess");
				}
			}
			catch(Exception ex){
				System.out.println("Exception at DataBase.MSAccess.QueryAccess " + ex.getMessage());
				ex.printStackTrace();
				RowCol = null;
			}
			finally{
				try {
					sqlStatement.close();
					conn.close();
				} catch (SQLException e) {
					System.out.println("Exception at DataBase.MSAccess.QueryAccess " + e.getMessage());
					e.printStackTrace();
				}
			}
			return RowCol;
		}
	}
	
}
