<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
	int a = 10;
%>
<% 
	int b = 20;
%>
<h2>aaa.jsp 입니다.</h2>
<%=request.getParameter("pid") %>,
<%=request.getParameter("marriage") %>
<br>
<%=a %>, <%=b %>,
<%=request.getParameter("pname") %>,
<%=request.getParameter("age") %>,
<%=request.getParameter("kor") %>,
<%=request.getParameter("eng") %>,
<%=request.getParameter("mat") %>,
<%=request.getAttribute("mem1") %>,
<%=request.getAttribute("mem2") %>