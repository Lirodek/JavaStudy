<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String main=(String)request.getAttribute("main");

	String mainURL = "main/"+main+".jsp";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/forward.css" />
</head>
<body>
<header>
	<jsp:include page="atop.jsp"/>
</header>
<section>
	<h3><%=main %> 페이지</h3>
	<jsp:include page="<%=mainURL %>"/>
</section>
<footer>
	<h2>난 바닥이야</h2>
</footer>

</body>
</html>