package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//import com.mysql.jdbc.Driver;

public class MyFirstJDBCWithProperties {
	public static void main(String[] args) {
		
		Connection conn=null;//reference variable of inbuilt interfaces
		Statement stmt=null;
		ResultSet rs=null;
		FileReader reader=null;
		try { 
			
			//program started from here
			reader=new FileReader("text.properties");
			Properties prop=new Properties();
			prop.load(reader);
			
			
			//step1:-load the Driver
//			Driver driver=new Driver();//driver is used to communicate with db 
//			DriverManager.registerDriver(driver);//here w register our driver.
			Class.forName("com.mysql.jdbc.Driver");
			
			//step2:- get the connection
			String url=prop.getProperty("url");
					//"jdbc:mysql://localhost:3306/UST_TY_DB?"
					//+"user=root&password=ROOT";
			conn= DriverManager.getConnection(url,prop);

			//step 3:-issue sql query
			stmt=conn.createStatement();
			String sql="select * from employee_info";
			rs=stmt.executeQuery(sql);
			
			//step 4:-Read the result
			while(rs.next()) {  //if(rs.next())
				int id=rs.getInt("id");   //int id=rs.getInt("1");
				String name=rs.getString("name");   //String name=rs.getString(2);
				int sal=rs.getInt("sal");       //int sal=rs.getInt(3);
				String gender=rs.getString("gender");  //String gender=rs.getString(4);
				
				System.out.println("id is"+id);
				System.out.println("name is"+name);
				System.out.println("salary is"+sal);
				System.out.println("gender is"+gender);
					
				System.out.println("---------------------");
			}
		}
		
		//step-5:-close all jdbc objects
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}if(reader!=null) {
					reader.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//endof main()
}
