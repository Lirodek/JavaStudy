<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%=request.getContextPath() %> <br>
<c:url value="/forward/info.jsp"/>
    <h1>난 로고 이지</h1>
<ul>
	<li><a href="/jspProj/forward/info.jsp">회사소개</a></li>
	<li><a href="<%=request.getContextPath() %>/forward/member.jsp">회원</a></li>
	<li><a href="<c:url value="/forward/gall.jsp"/>">갤러리</a></li>
	<li><a href="notice.jsp">공지사항</a></li>
	<li><a href="${pageContext.request.contextPath }/forward/mypage/cart.jsp">장바구니</a></li>
</ul>