<%@page import="jdbc_p.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
	int c = 300;
%>
<% 
	int d = 400;
%>
<h2>bbb.jsp 입니다.</h2>
<%=request.getParameter("pid") %>,
<%=request.getParameter("marriage") %>
<br>
<%=c %>, <%=d %>
<%-- <%=a %>, <%=b %> --%>
<%=request.getParameter("pname") %>,
<%=request.getParameter("age") %>,
<%=request.getParameter("kor") %>,
<%=request.getParameter("eng") %>,
<%=request.getParameter("mat") %>,
<%=request.getAttribute("mem1") %>,
<%=request.getAttribute("mem2") %>

<%

	request.setAttribute("mem2", new MemberDTO("정남성",30,true));
%>
