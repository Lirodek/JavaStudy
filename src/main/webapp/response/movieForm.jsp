<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movieForm</title>
</head>
<body>
<h1>movieForm</h1>
<form action="movieReg.jsp">
	<table border="">
		<tr>
			<td>제목</td>
			<td>
				<input type="radio" name="title" value="super" />수퍼맨
				<input type="radio" name="title" value="iron" />아이언맨
				<input type="radio" name="title" value="mart" />마트맨
			</td>
		</tr>
		<tr>
			<td>인원수</td>
			<td>
				<select name="cnt">
					<% for(int i = 1; i<10;i++){ %>
						<option value="<%=i%>"><%=i%>명</option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="예약" />
			</td>
		</tr>
	</table>
</form>


</body>
</html>