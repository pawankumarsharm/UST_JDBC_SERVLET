package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;


public class DynamicSelectQuerywithproperties {
public static void main(String[] args) {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	FileReader reader=null;
	
	try { 
		reader=new FileReader("text.properties");
		Properties prop=new Properties();
		prop.load(reader);
		Class.forName(prop.getProperty("driver-class-name"));
		
		String url=prop.getProperty("url");
		conn= DriverManager.getConnection(url,prop);
		
		
		pstmt=conn.prepareStatement(prop.getProperty("select-query"));
		
		String empid= args[0];
		int id=Integer.parseInt(empid);
		pstmt.setInt(1,id);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			int emp_id=rs.getInt("id");   
			String name=rs.getString("name");   
			int sal=rs.getInt("sal");       
			String gender=rs.getString("gender"); 
			
			System.out.println("id is"+emp_id);
			System.out.println("name is"+name);
			System.out.println("salary is"+sal);
			System.out.println("gender is"+gender);
				
			System.out.println("---------------------");
		}
	}
	
	catch(Exception e) {
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
			}if(reader!=null) {
				reader.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}//endof main()
}//end of myfirstjdbc
