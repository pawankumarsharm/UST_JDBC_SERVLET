package com.ustglobal.jdbcapp;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class DynamicUpdateQuery {
public static void main(String[] args) {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//Class.forName("com.mysql.jdbc.Driver");
		
	String url="jdbc:mysql://localhost:3306/UST_TY_DB?user=root&password=ROOT";
	conn=DriverManager.getConnection(url);
	
	String sql="update employee_info set name=?, sal=?,gender=? where id=?";
	pstmt = conn.prepareStatement(sql);
	
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
	
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(conn!=null) {
				conn.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
	}
	
}
}
}
