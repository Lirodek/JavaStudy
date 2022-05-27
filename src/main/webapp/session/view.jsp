<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	HttpSession hs = request.getSession();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>
<h1>view</h1>
id : <%=session.getId() %>,  <%=hs.getId() %><br>
생성시간 : <%=new Date( session.getCreationTime()) %>,
<%=new Date( hs.getCreationTime()) %>
<br>
최근접속시간 : <%=sdf.format( session.getLastAccessedTime()  ) %>,
<%=sdf.format( hs.getLastAccessedTime()  ) %><br>
-------------------------------<br>
<% //session.invalidate();
%>
id : <%=session.getId() %>,  <%=hs.getId() %><br>
-------------------------------<br>
no:<%=session.getAttribute("no") %><br>
mm1:<%=session.getAttribute("mm1") %><br>
mm2:<%=session.getAttribute("mm2") %><br>
</body>
</html>