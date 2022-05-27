<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String pid =  URLEncoder.encode("엄마상어", "UTF-8") ;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jspProj_jsp</h1>
<h2>basic</h2>
<a href="basic/01_first.jsp">01_first.jsp</a>
<a href="basic/02_sec.html">02_sec.html</a>
<a href="basic/03_lifeCycle.jsp">03_lifeCycle</a>
<a href="basic/04_diary.jsp">04_diary</a>
<a href="basic/05_out.jsp">05_out</a>
<h2>request</h2>
<a href="req/aaa.jsp?pid=<%=pid %>&no=1234&marriage=true">aaa</a>
<a href="req/joinForm.jsp">joinForm</a>
<a href="req/examForm.jsp">examForm</a>
<h2>response</h2>
<a href="response/aaa.jsp">aaa</a>
<a href="response/ccc.jsp">ccc</a>
<a href="response/movieForm.jsp">movieForm</a>

<h2>application</h2>
<a href="application/info.jsp">info</a>
<a href="application/set1.jsp">set1</a>
<a href="application/get.jsp">get</a>
<a href="application/set2.jsp">set2</a>
<a href="application/remove.jsp">remove</a>
<a href="application/login/main.jsp">로그인</a>
<h2>include</h2>
<a href="inc/big.jsp?pid=zzz&marriage=true">include</a>
<a href="inc/home.jsp">home</a>
<a href="inc/big2.jsp?pid=qwer&marriage=false">include디렉티브</a>
<h2>forward</h2>
<a href="forward/aaa.jsp?pid=qaz&age=27&marriage=1">aaa</a>
<a href="forward/member.jsp">member</a>
<h2>exception</h2>
<a href="error/err01.jsp">err01</a>
<a href="error/err02.jsp">err02</a>
<a href="error/err03.jsp">err03</a>
<a href="error/err04.jsp">err04</a>
<h2>cookie</h2>
<a href="cookie/set1.jsp">set1</a>
<a href="cookie/view.jsp">view</a>
<a href="cookie/set2.jsp">set2</a>
<a href="cookie/delete.jsp">delete</a>
<a href="cookie/login/main.jsp">로그인</a>
<h2>session</h2>
<a href="session/set1.jsp">set1</a>
<a href="session/view.jsp">view</a>
<a href="session/set2.jsp">set2</a>
<a href="session/delete.jsp">delete</a>
<a href="session/login/main.jsp">로그인</a>
<h2>useBean</h2>
<a href="useBean/bean.jsp?pid=qaz&age=27&marriage=true&tel=1234567">bean</a>
<a href="useBean/joinForm.jsp">joinForm</a>
<h2>dbcp</h2>
<a href="dbcp/memberList.jsp">memberList</a>
<h2>jstl</h2>
<a href="jstl/el.jsp?pid=qaz&age=27&marriage=true&tel=1234567">el</a>
<a href="jstl/02_exam.jsp?pid=asdf&kor=78&eng=79&mat=72">02_exam</a>
<a href="jstl/set_if.jsp">set_if</a>
<a href="jstl/foreach.jsp">foreach</a>
<a href="jstl/memberList.jsp">memberList</a>
<a href="jstl/fmt.jsp">fmt</a>

<h2>file</h2>
<a href="file/uploadForm.jsp">uploadForm</a>
<a href="file/joinForm.jsp">joinForm</a>
<a href="file/fileDown.jsp">fileDown</a>
<a href="file/fileDown2.jsp?fName=<%=URLEncoder.encode("이력서.hwp","utf-8") %>">이력서</a>
<a href="file/fileDown2.jsp?fName=bg.jpg">배경그림</a>
<a href="file/fileDown2.jsp?fName=BigBuck.mp4">영상</a>
<h2><a href="board/List">게시판</a></h2>
</body>
</html>