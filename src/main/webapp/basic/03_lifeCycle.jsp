<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //디렉티브 구간 %>  
<%!
	// class 03_lifeCycle_jsp {
	
	//}

	//declaration -- 클래스 정의부
	
	//멤버 변수
	int a = 10;
	String b = "아기상어";
	Date now = new Date();

	//메소드
	void meth_1(){
		System.out.println("meth_1() 실행");
	}
	
	void meth_2(){
		//out.println("meth_2() 실행");
		System.out.println("meth_2() 실행");
	}
	/* 직접적인 실행구문 작성 불가
	if(true){
		System.out.println("참이지롱");
	}*/
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_lifeCycle</title>
<style>
	div{
		width:50px;
		height: 50px;
		background: #ff0;
		border: 1px solid #000;
	}
</style>
</head>
<body>
<h2>03_lifeCycle</h2>
<%
	//scriptlet : _jspService() 메소드 정의 ::> main 과 같다.
	//실제 코드 실행이 된다.
	out.println("와 scriptlet 이다 1:"+a+","+b+","+now+"<br>");
	int aa = 20;
	String bb = "엄마상어";
	out.println("와 scriptlet 이다 2<br>"+aa+","+bb+"<br>");
	class AAA{
		
	}
	out.println("와 scriptlet 이다 3<br>");

	/* 메소드에서 메소드 정의 불가
	void meth_3(){
		
		out.println("meth_3() 실행");
	} */
	
	for(int i = 0; i<10;i++){
		
	
%> 
<%-- <div><% out.println(i); %></div> --%>

<div><%=i  %></div> 
<% } %>

</body>
</html>