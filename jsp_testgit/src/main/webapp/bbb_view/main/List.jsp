<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>게시판 리스트 입니다.</h2>

<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	<c:forEach var="dto" items="${mainData }" varStatus="no">
	<tr>
		<td>${no.index }</td>
		<td colspan="1">	
		 	<a href="<c:url value="/board/Detail?id=${dto.id}"/>">${dto.title }</a>
		</td>
		<td>${dto.p_name }</td>
		<td>
		<fmt:formatDate value="${dto.reg_date }" pattern="yy-MM-dd HH:mm"/>
		</td>
		
		<td>${dto.cnt }</td>
	</tr>
	</c:forEach>
</table>