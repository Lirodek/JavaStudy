<%@page import="jdbc_p.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<h1>로그아웃</h1>
<% 

	String perName = null;
	for(Cookie coo: request.getCookies()){
		if(coo.getName().equals("pName")){
			perName = coo.getValue();
			break;	
		}
		
	}
	Cookie coo1 = new Cookie("pid","");
	coo1.setMaxAge(0);
	response.addCookie(coo1);
	coo1 = new Cookie("pName","");
	coo1.setMaxAge(0);
	response.addCookie(coo1);
	String msg = perName+"님 로그아웃되었습니다";
	
	
%>	

<script>
	alert("<%=msg%>");
	location.href = "main.jsp";
</script>
</body>
</html>