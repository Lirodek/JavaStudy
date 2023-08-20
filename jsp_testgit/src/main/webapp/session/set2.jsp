<%@page import="jdbc_p.MemberDTO"%>
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
	//session.setMaxInactiveInterval(5);
	session.setAttribute("no", 5678);
	session.setAttribute("mm1", new MemberDTO("ccc","투빈"));
	
%>
</body>
</html>