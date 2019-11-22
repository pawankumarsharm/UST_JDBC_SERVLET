package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
public class DynamIcDeleteQuerywithproperites {
public static void main(String[] args) {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	FileReader reader=null;
	try {
	reader=new FileReader("text.properties");
	Properties prop=new Properties();
	prop.load(reader);
	Class.forName(prop.getProperty("driver-class-name"));
	
	String url=prop.getProperty("url");
	conn= DriverManager.getConnection(url,prop);
	
	
	pstmt=conn.prepareStatement(prop.getProperty("delete-query"));
	
	

	pstmt.setInt(1,Integer.parseInt(args[0]));
	int delete=pstmt.executeUpdate();
	System.out.println("delete one row(s)"+delete);
	
	
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
		}catch (Exception e) {
			e.printStackTrace();
	}
	
}
}
}
