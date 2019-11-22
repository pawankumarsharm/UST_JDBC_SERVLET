package com.ustglobal.jdbcapp;

import java.sql.*;
//import com.mysql.jdbc.Driver;

public class DynamIcDeleteQuery {
public static void main(String[] args) {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	try {
//		Driver driver=new Driver();
//		DriverManager.registerDriver(driver);
		Class.forName("com.mysql.jdbc.Driver");
		
	String url="jdbc:mysql://localhost:3306/UST_TY_DB?user=root&password=ROOT";
	conn=DriverManager.getConnection(url);

	String sql="delete from employee_info where id=?";
	pstmt = conn.prepareStatement(sql);
	

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
		}catch (SQLException e) {
			e.printStackTrace();
	}
	
}
}
}
