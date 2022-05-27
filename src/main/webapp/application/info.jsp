<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application/info</title>
</head>
<body>
<h1>application/info</h1>
<%=application.getServerInfo() %><br>
<%=application.getMajorVersion() %><br>
<%=application.getMinorVersion() %><br>
<%=application.getRealPath("fff/f7.jpg") %><br>
<%
	URL uuu = application.getResource("fff/aaa.txt");
%>
<%=uuu %><br>
<%
	InputStream is = uuu.openStream();

	byte [] arr = new byte[100];
	
	while(is.available()>0){
		int size = is.read(arr);
		out.print(new String(arr,0,size));
	}




	is.close();

%>
</body>
</html>