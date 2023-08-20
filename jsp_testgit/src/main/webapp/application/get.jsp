<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pid = (String)application.getAttribute("pid");
	int[] zxcv = (int[])application.getAttribute("arr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get</title>
</head>
<body>
<h1>get</h1>
<% Enumeration em = application.getAttributeNames(); 

	while(em.hasMoreElements()){
		out.println(em.nextElement()+"<br>");
	}

%>
-------------------------<br>
pid:<%=pid %><br>
age:<%=application.getAttribute("age") %><br>
arr:<%=Arrays.toString(zxcv) %><br>
mem:<%=application.getAttribute("mem") %><br>

</body>
</html>