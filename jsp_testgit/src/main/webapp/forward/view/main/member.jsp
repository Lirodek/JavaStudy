<%@page import="jdbc_p.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% ArrayList<MemberDTO> mems = (ArrayList<MemberDTO>)request.getAttribute("mems");
	for(MemberDTO mm : mems){
		out.println(mm+"<br>");
	}
%>