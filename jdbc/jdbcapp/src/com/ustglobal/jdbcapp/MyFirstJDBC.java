package com.ustglobal.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class MyFirstJDBC {
public static void main(String[] args) {
	
	Connection conn=null;//reference variable of inbuilt interfaces
	Statement stmt=null;
	ResultSet rs=null;
	
	try { //step1:-load the Driver                               //program started from here
		Driver driver=new Driver();//driver is used to communicate with db 
		DriverManager.registerDriver(driver);//here w register our driver.
		//Class.forName("com.mysql.jdbc.Driver");
		
		//step2:- get the connection
		String url=
				"jdbc:mysql://localhost:3306/UST_TY_DB?"
				+"user=root&password=ROOT";
		conn= DriverManager.getConnection(url);

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
	catch(SQLException e) {
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
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}//endof main()
}//end of myfirstjdbc
