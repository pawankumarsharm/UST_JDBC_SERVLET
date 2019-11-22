package com.ustglobal.jdbcapp;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class DeleteTryWithResources2 {
public static void main(String[] args) {
	
	try(FileReader reader=new FileReader("text.properties")){
		Properties prop=new Properties();
		prop.load(reader);
		Class.forName(prop.getProperty("driver-class-name"));
		
		String url=prop.getProperty("url");
		String sql=prop.getProperty("select-query");
	
		try(Connection conn= DriverManager.getConnection(url,prop);
				PreparedStatement pstmt=conn.prepareStatement(sql)){
		
			pstmt.setInt(1,Integer.parseInt(args[0]));
			int delete=pstmt.executeUpdate();
			System.out.println("delete one row(s)"+delete);
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
}
