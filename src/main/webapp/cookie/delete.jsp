<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>
<h1>delete</h1>
<%
	Cookie coo1 = new Cookie("pname","");
	Cookie coo2 = new Cookie("age","");

	coo1.setMaxAge(0); 
	coo2.setMaxAge(0); 
	
	response.addCookie(coo1);
	response.addCookie(coo2);
%>
</body>
</html>