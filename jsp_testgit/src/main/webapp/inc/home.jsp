<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String main = "info";

	if(request.getParameter("main")!=null){
		main = request.getParameter("main");
	}

	String mainUrl = "main/"+main+".jsp";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈이에요</title>
<link rel="stylesheet" href="../css/in_home.css" />
</head>
<body>
<header>
<jsp:include page="top.jsp"/>
</header>
<section>
	<jsp:include page="<%=mainUrl %>"/>

</section>
</body>
</html>