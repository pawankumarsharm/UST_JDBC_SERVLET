package com.ustglobal.webappp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet2 extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
Cookie[] cookie=req.getCookies();
PrintWriter out=resp.getWriter();
if(cookie==null) {
	out.println("<h1>No Cookie Found</h1>");
}else {
	for (Cookie cookie2 : cookie) {
		String name=cookie2.getName();
		if(name.equals("emp-name")) {
			cookie2.setMaxAge(0);
			
			out.println("<h1> for emp-name cookie is deleted</h1>");
		}
	}
}

	
	
}//end of doGet()
}//end of CreateCookieServlet
