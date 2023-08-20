<%@page import="jdbc_p.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set_if</title>
</head>
<body>
<h1>set_if</h1>
<cc:set var="nn1" value="차은우" />
<cc:set var="nn1" value="차은수" scope="request"/>
<cc:set var="nn1" value="차은미" scope="session" />
<cc:set var="nn1" value="차은양" scope="application"/>
<cc:set var="nn1" value="차은가" />
${nn1 }<br>
${requestScope.nn1 }<br>
${sessionScope.nn1 }<br>
${applicationScope.nn1 }<br>
-------------------------------------<br>
<cc:remove var="nn1"  scope="page"/>
${nn1 }<br>
<cc:remove var="nn1"  scope="request"/>
${nn1 }<br>
<cc:remove var="nn1"  scope="session"/>
${nn1 }<br>
<cc:remove var="nn1"  scope="application"/>
${nn1 }<br>
-------------------------------------<br>
<cc:set var="mm" value="<%=new MemberDTO(\"aaa\",\"김강규\") %>" />
<cc:set property="pw" target="${mm }" value="1q2w" />
${mm }<br>
<%-- ${mm.pid }  ==> mm.getPid() --%>
${mm.pid },${mm.pname },${mm.pw },${mm.age }<%-- ,${mm.tel } --%><br>
${mm.nickname }<br>

-------------------------------------<br>
<cc:if test="${false }">
	참이지롱<br>
</cc:if>
<cc:set var="jum" value="58" />
<cc:if test="${jum >= 80 }">
	<!-- 합격<br> -->
	<cc:set var="res" value="합격" />
</cc:if>
<%-- <cc:otherwise>
	<cc:set var="res" value="불합격" />
</cc:otherwise> --%>

res : ${res }<br>
-------------------------------------<br>
<cc:choose>
	<cc:when test="${jum >= 80 }">
		<cc:set var="res2" value="우수" />
	</cc:when>
	<cc:when test="${jum >= 60 }">
		<cc:set var="res2" value="정상" />
	</cc:when>
	<cc:otherwise>
		<cc:set var="res2" value="미흡" />
	</cc:otherwise>
</cc:choose>
res2 : ${res2 }<br>
</body>
</html>