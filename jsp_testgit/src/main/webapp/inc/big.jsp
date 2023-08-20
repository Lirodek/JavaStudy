<%@page import="jdbc_p.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setAttribute("mem1", new MemberDTO("정우성",10,false));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>big</title>
</head>
<body>
<h1>big</h1>
big.jsp 입니다. <br>
<%=request.getParameter("pid") %>,
<%=request.getParameter("marriage") %>,
<%=request.getAttribute("mem1") %>
<br>
<jsp:include page="aaa.jsp?pname=aaa&age=37">
	<jsp:param value="88" name="kor"/>
	<jsp:param value="78" name="eng"/>
	<jsp:param value="68" name="mat"/>
</jsp:include>
<br><br>
<%

	request.setAttribute("mem2", new MemberDTO("정좌성",20,false));
%>
<%=request.getAttribute("mem2") %>

<%-- <%=a %>, <%=b %> --%>
<br><br>
<jsp:include page="bbb.jsp"/>
<br><br>
<%=request.getAttribute("mem2") %>
</body>
</html>