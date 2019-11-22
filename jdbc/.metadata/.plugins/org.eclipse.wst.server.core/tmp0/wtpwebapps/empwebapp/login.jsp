<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="msg" class="java.lang.String" scope="request"/>
<%
String id="";
Cookie[] cookies=request.getCookies();
if(cookies!=null) {
for (Cookie cookie : cookies) {
	if(cookie.getName().equals("alwaysRemember")) {
		id=cookie.getValue();
	}
}	
}
%>
<body>
<h4><%=msg %>
<fieldset align='center'>
	<legend>Login</legend>
	<form action='./login' method='post'>
	<table>
	<tr>
	<td>Login-Id:</td>
	<td> <input name='id' type='number' value='<%=id%>'></td>
	</tr>
	<tr>
	<td>Login-Password:</td>
	<td>  <input type='password' name='password'></td>
	</tr>
	<tr>
	<td>Remember me:</td>
	<td>   <input type='checkbox' name='rememberme' value='check'></td>
	</tr>
	<tr>
	<td><input type='submit' value ='login'></td>
	</tr>
	<td><input type='submit' value ='reset'><br></td>
	<tr>
	<td><a href='./register.html'>register</a></td>
	</tr>
	</table>
	</form>
	</fieldset>









</body>
</html>