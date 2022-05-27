<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>게시판 리스트 입니다.</h2>

<table border="1">
	<tr>
		<td>id</td><td>${dto.id }</td>
		</tr> <tr>
		<td>제목</td><td>${dto.title }</td>
		</tr> <tr>
		<td>작성자</td><td>${dto.p_name }</td>
		</tr> <tr>
		<td>
		<fmt:formatDate value="${dto.reg_date }" pattern="yy-MM-dd HH:mm:ss"/>
		</td>
		</tr> <tr>
		<td>조회수</td><td>${dto.cnt }</td>
		</tr> <tr>
	</tr>
</table>