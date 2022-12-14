package utils;

import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ConnectionWithExcel {
	     Fillo fillo;
	     Connection connect;
	    public void getExcelConnection() {
	    	String xcelPath="C:\\eclipse_selenium\\BDDSample\\src\\test\\resources\\testData\\Testdata.xlsx";
	    	fillo =new Fillo();
	    	try {
				connect= fillo.getConnection(xcelPath);
			} catch (FilloException e) {
				System.out.println("Not got connected");
				e.printStackTrace();
			}
	    	
	    }
	    public HashMap<String,String> loadTestData(String sTCid) {
	    	
	    	this.getExcelConnection();
	    	
	    	String query= "select * from TestData where TC_ID='"    +sTCid+    "'";
	        HashMap<String,String> userList = new HashMap<String,String>();
	        HashMap<String,HashMap<String,String>> data = new HashMap<String,HashMap<String,String>>();
	        Recordset rs = null;
	    	try {
				rs=connect.executeQuery(query);
				int columnCount = rs.getFieldNames().size();
				System.out.println("columnCount"+ columnCount);
				if(rs.next()) {
					
				for(int k =0;k< columnCount;k++) {
					
//					System.out.println("col key"+ rs.getFieldNames().get(k));
//					System.out.println("col value"+ rs.getField(k).value());
					userList.put(rs.getFieldNames().get(k) ,rs.getField(k).value());
					//data.put(sTCid, userList)
					
								}
				return userList;
				}
																
				System.out.println("userList size " + userList.size());
				
			
	    	}catch (FilloException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return userList;
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		/*
		 * public void querySheet(String sTCid) {
		 * 
		 * String query= "select * from TestData where TC_ID='"+sTCid+"'"; String[]
		 * aryData=null; Recordset rs = null; try { rs=connect.executeQuery(query); int
		 * columnCount = rs.getFieldNames().size(); if(rs.next()) { aryData= new
		 * String[columnCount]; for(int i=0;i<columnCount;i++) {
		 * System.out.println(rs.getField(i).value());
		 * aryData[i]=rs.getField(i).value(); }
		 * 
		 * } } catch (FilloException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * }
		 */
}
