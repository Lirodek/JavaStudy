<%@page import="jdbc_p.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pid=vvv&no=1234&marriage=true
	//String pid = request.getParameter("pid");
	//int no = request.getParameter("no");
	//String no = request.getParameter("no");
	/* int no = 0;
	
	if(request.getParameter("no")!=null){
		no = Integer.parseInt(request.getParameter("no"));
	} */
	//String marriage = request.getParameter("marriage");
	
	MemberDTO dto = new MemberDTO();
	//dto.pid = pid;
	
	//dto.setPid( request.getParameter("pid"));
	//dto.setNo(request.getParameter("no"));
	dto.init(request);
	
	System.out.println(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aaa</title>
</head>
<body>
<h1>aaa</h1>
pid:<%=dto.getPid() %><br>
no:<%= dto.getNo() %><br>
marriage:<%= dto.isMarriage() %><br>
</body>
</html>