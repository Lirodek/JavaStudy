<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %> 

<cc:set var="tot" value="${param.kor+param.eng+param.mat }"/>  
<cc:set var="avg" value="${tot/3}"/> 
<cc:choose>
	<cc:when test="${avg>= 90 }">
		<cc:set var="grade" value="수"/> 
	</cc:when>
	<cc:when test="${avg>= 80 }">
		<cc:set var="grade" value="우"/> 
	</cc:when>
	<cc:when test="${avg>= 70 }">
		<cc:set var="grade" value="미"/> 
	</cc:when>
	<cc:when test="${avg>= 60 }">
		<cc:set var="grade" value="양"/> 
	</cc:when>
	<cc:otherwise>
		<cc:set var="grade" value="가"/> 
	</cc:otherwise>
</cc:choose>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_exam</title>
</head>
<body>
<h1>02_exam</h1>
<table border="">
	<tr>
		<td>아이디</td>
		<td>${param.pid }</td>
	</tr>
	<tr>
		<td>국어</td>
		<td>${param.kor }</td>
	</tr>
	<tr>
		<td>영어</td>
		<td>${param.eng }</td>
	</tr>
	<tr>
		<td>수학</td>
		<td>${param.mat }</td>
	</tr>
	<tr>
		<td>총점</td>
		<td>${tot }</td>
	</tr>
	<tr>
		<td>평균</td>
		<td>${avg }</td>
	</tr>
	<tr>
		<td>등급</td>
		<td>${grade }</td>
	</tr>
</table>

</body>
</html>