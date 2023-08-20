<%@page import="jdbc_p.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDAO dao = new MemberDAO();
//dao.list(1);
//dao.close();
	request.setAttribute("mems",  dao.list(1));
	request.setAttribute("main",  "member" );
%>
<jsp:forward page="view/template.jsp"/>