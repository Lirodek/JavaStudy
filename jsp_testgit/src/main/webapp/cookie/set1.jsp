<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set1</title>
</head>
<body>
<h1>set1</h1>
<%
	Cookie coo1 = new Cookie("pname","aaa");
	coo1.setMaxAge(5);  //5초동안 쿠키 존속
	Cookie coo2 = new Cookie("age","45");

	response.addCookie(coo1);
	response.addCookie(coo2);
%>
</body>
</html>