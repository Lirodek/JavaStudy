<%@page import="bas.OutGoGo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="8kb" autoFlush="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_out</title>
</head>
<body>
<h1>05_out</h1>
<%=out.getBufferSize() %>, <%=out.getRemaining() %><br>
<%
	out.println("아기상어<br>");
	out.println("엄마상어<br>");
	out.println("아빠상어<br>");
%>
<%=out.getBufferSize() %>, <%=out.getRemaining() %><br>
<%="할머니상어<br>할아버지상어<br>" %>
<%=out.getBufferSize() %>, <%=out.getRemaining() %><br>
오빠상어<br>육빠상어<br>칠빠상어<br>
<%=out.getBufferSize() %>, <%=out.getRemaining() %><br>

<%
	JspWriter jw = out;
	JspWriter jw2 = pageContext.getOut();
	OutGoGo ogg = new OutGoGo(out);
%>
<%=jw.getBufferSize() %>, <%=jw.getRemaining() %><br>
<%=jw2.getBufferSize() %>, <%=jw2.getRemaining() %><br>
<% ogg.wrwr(); %>
<%=jw2.getBufferSize() %>, <%=jw2.getRemaining() %><br>
<% 
	//out.clear(); 클라이언트에 보낼 버퍼에 저장된 내용을 모두 지움
	out.flush();  //버퍼내용을 전송하고 버퍼 지운다
%>
<%=jw2.getBufferSize() %>, <%=jw2.getRemaining() %><br>
</body>
</html>