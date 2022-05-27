<%@page import="jdbc_p.MemberDTO"%>
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
	session.setAttribute("no", 1234);
	session.setAttribute("mm1", new MemberDTO("aaa","현빈"));
	session.setAttribute("mm2", new MemberDTO("bbb","원빈"));
%>
</body>
</html>