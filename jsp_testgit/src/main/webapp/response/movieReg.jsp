<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String title = request.getParameter("title");

	int cnt = Integer.parseInt(request.getParameter("cnt"));
	
	
	switch(title){
		case "super":
			cnt++;
			break;
		case "mart":
			cnt*=2;
			break;
		case "iron":
			cnt-=1;
			break;
	}
	
	response.sendRedirect("movie/"+title+".jsp?cnt="+cnt);

%>