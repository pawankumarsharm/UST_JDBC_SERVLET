package com.ustglobal.jdbcapp;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class InsertTryWithResources {
public static void main(String[] args) {
	
	try(FileReader reader=new FileReader("text.properties")){
		Properties prop=new Properties();
		prop.load(reader);
		Class.forName(prop.getProperty("driver-class-name"));
		
		String url=prop.getProperty("url");
		String sql=prop.getProperty("insert-query");
	
		
		try(Connection conn= DriverManager.getConnection(url,prop);
			PreparedStatement stmt=conn.prepareStatement(sql)){
		
			String empid=args[0];
			int id=Integer.parseInt(empid);
			stmt.setInt(1,id);
			
			String name=args[1];
			stmt.setString(2,name);
			
			String empsal=args[2];
			int sal=Integer.parseInt(empsal);
			stmt.setInt(3, sal);
			
			String gender=args[3];
			stmt.setString(4,gender);
			
			int count=stmt.executeUpdate();
			
			System.out.println(count+"Row(s) Inserted");
			System.out.println("---------------------");
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
}
