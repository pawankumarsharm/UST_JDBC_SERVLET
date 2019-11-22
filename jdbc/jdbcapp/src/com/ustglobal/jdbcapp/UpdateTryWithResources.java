package com.ustglobal.jdbcapp;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class UpdateTryWithResources {
public static void main(String[] args) {
	
	try(FileReader reader=new FileReader("text.properties")){
		Properties prop=new Properties();
		prop.load(reader);
		Class.forName(prop.getProperty("driver-class-name"));
		
		String url=prop.getProperty("url");
		String sql=prop.getProperty("update-query");
	
		
		try(Connection conn= DriverManager.getConnection(url,prop);
				PreparedStatement stmt=conn.prepareStatement(sql)){
		
			String empid=args[0];
			int id=Integer.parseInt(empid);
			
			String name=args[1];
			
			String empsal=args[2];
			int sal=Integer.parseInt(empsal);
			
			String gender=args[3];

			stmt.setInt(4,id);
			stmt.setString(1,name);
			stmt.setInt(2,sal);
			stmt.setString(3, gender);
			
			int update=stmt.executeUpdate();
			
			System.out.println("update one row(s)"+update);
			
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
}
