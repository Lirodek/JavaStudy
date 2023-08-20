<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinReg</title>
<link rel="stylesheet" type="text/css" href="../css/joinForm.css">
</head>
<body>
<h1>joinReg</h1>
<%
	/* 5명의 학생의 정보를 받아 출력하는 페이지를 구성하세요
	구성내용
	이름, 국어,영어, 수학
	
	출력 : 이름, 국어,영어, 수학, 총점, 평균
	
	클래스 단위로 변경하여 처리할 것
 */
	request.setCharacterEncoding("utf-8");
	String [] hjobbys = request.getParameterValues("hobby");

	for(String tt: "pid,pname,pw,tel0,tel1,tel2,hobby,gender,content".split(",")){
%>
<div class="big">
	<div><%=tt %></div>
	<div><%=request.getParameter(tt) %></div>
</div>

<%} %>
<div class="big">
	<div>취미들</div>
	<div><%=Arrays.toString(hjobbys) %></div>
</div>
</body>
</html>