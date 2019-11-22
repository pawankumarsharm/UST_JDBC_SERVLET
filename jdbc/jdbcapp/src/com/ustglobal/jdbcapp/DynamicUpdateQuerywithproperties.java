package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class DynamicUpdateQuerywithproperties {
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
		
		
		pstmt=conn.prepareStatement(prop.getProperty("update-query"));
		
	
	String empid=args[0];
	int id=Integer.parseInt(empid);
	
	String name=args[1];
	
	String empsal=args[2];
	int sal=Integer.parseInt(empsal);
	
	String gender=args[3];

	pstmt.setInt(4,id);
	pstmt.setString(1,name);
	pstmt.setInt(2,sal);
	pstmt.setString(3, gender);
	
	int update=pstmt.executeUpdate();
	
	System.out.println("update one row(s)"+update);
	
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(conn!=null) {
				conn.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}	if(reader!=null) {
				reader.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
	}
	
}
}
}
