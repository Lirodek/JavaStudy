<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="../excep/excep02.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>err02</title>
</head>
<body>
<h1>err02</h1>
<%
	
		int a = 10/0;

		out.println("정상실행:"+ a);

%>

</body>
</html>