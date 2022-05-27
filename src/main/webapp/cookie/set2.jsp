<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set2</title>
</head>
<body>
<h1>set2</h1>
<%
	Cookie coo2 = new Cookie("pname","bbb");
	
	response.addCookie(coo2);
%>
</body>
</html>