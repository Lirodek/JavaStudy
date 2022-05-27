<%@page import="jdbc_p.MemberDTO"%>
<%@page import="jdbc_p.DBCP_DAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>
<h1>memberList</h1>
<%
	ArrayList<MemberDTO> arr = new DBCP_DAO().list(1);
	for(MemberDTO dto : arr){%>
		<%=dto %><br>
<%}%>
</body>
</html>