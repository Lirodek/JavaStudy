<%@page import="jdbc_p.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward/bbb</title>
</head>
<body>
<h1>forward/bbb 입니다</h1>
pid:<%=request.getParameter("pid") %><br>
age:<%=request.getParameter("age") %><br>
kor:<%=request.getParameter("kor") %><br>
eng:<%=request.getParameter("eng") %><br>
mat:<%=request.getAttribute("mat") %><br>
회원들-----<br>
<% ArrayList<MemberDTO> mems = (ArrayList<MemberDTO>)request.getAttribute("mems");
	for(MemberDTO mm : mems){
		out.println(mm+"<br>");
	}
%>

</body>
</html>