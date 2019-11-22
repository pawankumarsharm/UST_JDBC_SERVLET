package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class DynamicInsertQuery {
public static void main(String[] args) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	FileReader reader=null;
	try {
		reader=new FileReader("text.properties");
		Properties prop=new Properties();
		prop.load(reader);
		
		//step 1:-load the driver
		
		Class.forName(prop.getProperty("driver-class-name"));
		
		//step-2:-Get the Connection
		String url=prop.getProperty("url");
		conn= DriverManager.getConnection(url,prop);
		
		//step-3:-Issue the query
		
		pstmt=conn.prepareStatement(prop.getProperty("insert-query"));
		
		String empid=args[0];
		int id=Integer.parseInt(empid);
		pstmt.setInt(1,id);
		
		String name=args[1];
		pstmt.setString(2,name);
		
		String empsal=args[2];
		int sal=Integer.parseInt(empsal);
		pstmt.setInt(3, sal);
		
		String gender=args[3];
		pstmt.setString(4,gender);
		
		int count=pstmt.executeUpdate();
		
		System.out.println(count+"Row(s) Inserted");
	} catch (Exception e) {
		e.printStackTrace();
	
	}finally {
	
		try {
				if(conn!=null) {
				conn.close();
			}
				if(pstmt!=null) {
					pstmt.close();
			}
				if(reader!=null) {
					reader.close();
				}
		}
				catch (Exception e) {
				e.printStackTrace();
		}
		}
	
	
	
}//end of main
}//end of execute insert query
