package com.ustglobal.empapp;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import com.ustglobal.empapp.dao.EmployeeDAO;
import com.ustglobal.empapp.dao.EmployeeDAOImpl;
import com.ustglobal.empapp.dto.EmployeeBean;
import com.ustglobal.empapp.util.EmployeeManager;


public class App {
public static void main(String[] args) {
	System.out.println("Press 1 to get all employee data");
	System.out.println("Press 2 to insert employee data");
	System.out.println("Press 3 to update employee data");
	System.out.println("Press 4 to delete employee data");
	System.out.println("Press 5 to search single employee data");
	
	Scanner scn=new Scanner(System.in);
	int ch=scn.nextInt();
	
	switch(ch) {
	case 1:
		EmployeeDAO dao=EmployeeManager.getEmployeeDAO();		List<EmployeeBean> result=dao.getALLEmployeeData();
		
		for (EmployeeBean bean : result) {
			System.out.println("Name is:"+bean.getName());
			System.out.println("Id is:-"+bean.getId());
			System.out.println("Gender is:"+bean.getGender());
			System.out.println("Salary is:"+bean.getSal());
		}
		break;
	case 2:
		EmployeeDAO dao2=EmployeeManager.getEmployeeDAO();
		int id1=scn.nextInt();
		String name=scn.next();
		int sal=scn.nextInt();
		String gender=scn.next();
		EmployeeBean bean1=new EmployeeBean();
		bean1.setId(id1);
		bean1.setName(name);
		bean1.setSal(sal);
		bean1.setGender(gender);
		
		int res=dao2.insertEmployeeData(bean1);
		System.out.println(res+"Row(s) inserted");
		break;
	
	case 3:
		EmployeeDAO dao3=EmployeeManager.getEmployeeDAO();
		int id2=scn.nextInt();
		String name2=scn.next();
		int sal2=scn.nextInt();
		String gender2=scn.next();
		EmployeeBean bean2=new EmployeeBean();
		bean2.setId(id2);
		bean2.setName(name2);
		bean2.setSal(sal2);
		bean2.setGender(gender2);
		
		int res2=dao3.updateEmployeeData(bean2);
		System.out.println(res2+"Row(s) inserted");
		break;
		
	case 4:
		EmployeeDAO dao4=EmployeeManager.getEmployeeDAO();
		int id3=scn.nextInt();
		int res3=dao4.deleteEmployeeData(id3);
		System.out.println(res3+"Row(s) deleted");
		break;
		
	case 5:
		EmployeeDAO dao5=EmployeeManager.getEmployeeDAO();
		System.out.println("Enter the id");
		int id=scn.nextInt();
		EmployeeBean bean=dao5.searchEmployeeData(id);
		if(bean!=null) {
			System.out.println("Name is:"+bean.getName());
			System.out.println("Id is:-"+bean.getId());
			System.out.println("Gender is:"+bean.getGender());
			System.out.println("Salary is:"+bean.getSal());	
		}
		else {
			System.out.println("data not found");
		}
		break;
	}
	
	
}
}
