<%@page import="jdbc_p.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
<h1>로그인 처리</h1>
<%
	String id = "asdf", pw = "1234", msg="로그인 실패";

	if(id.equals(request.getParameter("pid")) && 
			pw.equals(request.getParameter("pw"))	
	){
		msg = "로그인 성공";
		
		application.setAttribute("inUser", new MemberDTO("asdf","현빈"));
	}
%>

<script>
	alert("<%=msg%>");
	location.href = "main.jsp";
</script>

</body>
</html>