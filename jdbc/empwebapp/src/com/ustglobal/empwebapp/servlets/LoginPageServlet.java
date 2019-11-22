package com.ustglobal.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.Response;
import com.ustglobal.empwebapp.dao.EmployeeDAO;
import com.ustglobal.empwebapp.dto.EmployeeInfo;
import com.ustglobal.webapp.util.EmployeeDaoManager;

@WebServlet("/login.html")
public class LoginPageServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out=resp.getWriter();
	
	String id="";
	Cookie[] cookies=req.getCookies();
	if(cookies!=null) {
	for (Cookie cookie : cookies) {
		if(cookie.getName().equals("alwaysRemember")) {
			id=cookie.getValue();
		}
	}	
	}
	
	

}//end of do Get
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}//end of LoginServlet
