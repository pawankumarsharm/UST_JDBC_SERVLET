package com.ustglobal.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class DynamicSelectQuery {
public static void main(String[] args) {
	
	Connection conn=null;//reference variable of inbuilt interfaces
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try { 
		//step1:-load the Driver                               //program started from here
		Driver driver=new Driver();//driver is used to communicate with db 
		DriverManager.registerDriver(driver);//here w register our driver.
		//Class.forName("com.mysql.jdbc.Driver");
		
		
		//step2:- get the connection
		String url=
				"jdbc:mysql://localhost:3306/UST_TY_DB?"
				+"user=root&password=ROOT";
		conn= DriverManager.getConnection(url);

		//step 3:-issue sql query
		
		String sql="select * from employee_info where id=?";
		pstmt=conn.prepareStatement(sql);
		
		String empid= args[0];
		int id=Integer.parseInt(empid);
		pstmt.setInt(1,id);
		
		rs=pstmt.executeQuery();
		
		//step 4:-Read the result
		if(rs.next()) {  //if(rs.next())
			int emp_id=rs.getInt("id");   //int id=rs.getInt("1");
			String name=rs.getString("name");   //String name=rs.getString(2);
			int sal=rs.getInt("sal");       //int sal=rs.getInt(3);
			String gender=rs.getString("gender");  //String gender=rs.getString(4);
			
			System.out.println("id is"+emp_id);
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
			if(pstmt!=null) {
				pstmt.close();
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
