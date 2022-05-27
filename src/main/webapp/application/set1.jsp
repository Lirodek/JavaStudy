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
	application.setAttribute("pid", "aaa");
	application.setAttribute("age", 35);
	application.setAttribute("arr", new int[]{11,22,33,44});
	application.setAttribute("mem", new MemberDTO("정우성",29,true));
	//application.setAttribute(1234, "aaa"); key 가 String 이어야 한다.
%>
</body>
</html>