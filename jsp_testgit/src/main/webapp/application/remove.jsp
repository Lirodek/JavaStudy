<%@page import="jdbc_p.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>remove</title>
</head>
<body>
<h1>remove</h1>
<%
	application.removeAttribute("pid");
	application.removeAttribute("age");

	application.removeAttribute("mem");

%>
</body>
</html>