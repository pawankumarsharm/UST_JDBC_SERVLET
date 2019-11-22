package com.ustglobal.jdbcapp;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class ExcecuteUpdateQuery {
public static void main(String[] args) {
	
	Connection conn=null;
	Statement stmt=null;
	
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//Class.forName("com.mysql.jdbc.Driver");
		
	String url="jdbc:mysql://localhost:3306/UST_TY_DB?user=root&password=ROOT";
	conn=DriverManager.getConnection(url);
	
	String sql="update employee_info set name='PAWAN', sal=50000,gender='M' where id=6";
	stmt = conn.createStatement();
	int update=stmt.executeUpdate(sql);
	System.out.println("update one row(s)"+update);
	
	
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(conn!=null) {
				conn.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
	}
	
}
}
}
