package com.ustglobal.empapp.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ustglobal.empapp.dto.EmployeeBean;

public class EmployeeDAOImpl implements EmployeeDAO {
public List<EmployeeBean> getALLEmployeeData() {
	String url="jdbc:mysql://localhost:3306/UST_TY_DB?user=root&password=ROOT";
	String sql="select * from employee_info";
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		stmt=conn.createStatement();
		rs= stmt.executeQuery(sql);
		ArrayList<EmployeeBean> result=new ArrayList<EmployeeBean>();
		while(rs.next()) {
			EmployeeBean bean=new EmployeeBean();
			int id=rs.getInt("id");
			bean.setId(id);
			
			String name=rs.getString("name");
			bean.setName(name);
			
			int sal=rs.getInt("sal");
			bean.setSal(sal);
			
			
			String gender=rs.getString("gender");
			bean.setGender(gender);
			
			result.add(bean);
			
		}
		return result;
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}finally{
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
	}catch(Exception e) {
		e.printStackTrace();
	}
}//end of try catch
}//end of getALLEmployeeData()

public EmployeeBean searchEmployeeData(int id) {
	String url="jdbc:mysql://localhost:3306/UST_TY_DB?user=root&password=ROOT";
	String sql="select * from employee_info where id=?";
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url);
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			EmployeeBean bean=new EmployeeBean();
			bean.setId(rs.getInt("id"));
			bean.setName(rs.getString("name"));
			bean.setSal(rs.getInt("sal"));
			bean.setGender(rs.getString("gender"));
			
			return bean;
		}else {
			return null;
		}
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	
	}finally{
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
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	}

@Override
public int insertEmployeeData(EmployeeBean bean) {
	String url="jdbc:mysql://localhost:3306/UST_TY_DB?user=root&password=ROOT";
	String sql="insert into employee_info values(?,?,?,?)";
	Connection conn=null;
	PreparedStatement stmt=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,bean.getId());
		stmt.setString(2,bean.getName());
		stmt.setInt(3, bean.getSal());
		stmt.setString(4,bean.getGender());
		
		int count=stmt.executeUpdate();
		
		return count;
	}catch(Exception e) {
		e.printStackTrace();
		return 0;
	}finally{
		try {
			if(conn!=null) {
				conn.close();
			}
			if(stmt!=null) {
				stmt.close();
		}
			
	}catch(Exception e2) {
		e2.printStackTrace();
	}
	}
}
@Override
public int updateEmployeeData(EmployeeBean bean) {
	String url="jdbc:mysql://localhost:3306/UST_TY_DB?user=root&password=ROOT";
	String sql="update employee_info set name=?,sal=?,gender=? where id=?";
	Connection conn=null;
	PreparedStatement stmt=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,bean.getId());
		stmt.setString(2,bean.getName());
		stmt.setInt(3, bean.getSal());
		stmt.setString(4,bean.getGender());
		
		int count1=stmt.executeUpdate();
		
		return count1;
	}catch(Exception e) {
		e.printStackTrace();
		return 0;
	}finally{
		try {
			if(conn!=null) {
				conn.close();
			}
			if(stmt!=null) {
				stmt.close();
		}
			
	}catch(Exception e2) {
		e2.printStackTrace();
	}
	}
}

@Override
public int deleteEmployeeData(int id) {
	// TODO Auto-generated method stub
	return 0;
}

}//end of class


