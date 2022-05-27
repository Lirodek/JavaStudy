<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Calendar today = Calendar.getInstance();

	today.set(Calendar.DATE,1);
	int first = today.get(Calendar.DAY_OF_WEEK);
	int year = today.get(Calendar.YEAR);
	int month = today.get(Calendar.MONTH)+1;
	int last = today.getActualMaximum(Calendar.DATE);
	System.out.println(first+","+last);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_diary</title>
<link rel="stylesheet" href="../css/04_diary.css" type="text/css">
</head>
<body>
<h1>04_diary</h1>
<div>
	<div><img src="../fff/f<%=month %>.jpg" alt="" /></div>
	<div><%=year+"年 "+month+"月" %></div>
	<div>

		<% for(char dd : "일월화수목금토".toCharArray()){ %>
			<div><%=dd %></div>
		
		
		<%} for(int i = 1; i<first; i++){%>
				<div></div>
		
		<%} for(int i = 1; i<=last; i++){ %>
			<div><%=i %></div>
		<%} %>
	</div>
</div>

</body>
</html>