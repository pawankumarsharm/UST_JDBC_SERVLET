package com.ustglobal.jdbcapp;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class ExecuteInsertQuery {
public static void main(String[] args) {
	Connection conn=null;
	Statement stmt=null;
	
	try {
		//step 1:-load the driver
		
	Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//Class.forName("com.mysql.jdbc.Driver");
		
		//step-2:-Get the Connection
		String url="jdbc:mysql://localhost:3306/UST_TY_DB?user=root&password=ROOT";
		conn=DriverManager.getConnection(url);
		
		//step-3:-Issue the query
		String sql="insert into employee_info values(6,'rahul',10000,'f')";
		stmt=conn.createStatement();
		int count=stmt.executeUpdate(sql);
		
		//step 4:-Read the result
		System.out.println(count+"Row(s) Inserted");
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
	
		try {
			if(conn!=null) {
				conn.close();
			}if(stmt!=null) {
				stmt.close();
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		}
	
	
	
}//end of main
}//end of execute insert query
