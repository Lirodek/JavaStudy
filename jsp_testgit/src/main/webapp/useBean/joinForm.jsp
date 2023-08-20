<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
</head>
<body>
<h1>joinForm</h1>
<form action="joinReg.jsp" method="post">
	<table border="">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="pid" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="pname" /></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="text" name="pw" /></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" /></td>
		</tr>
		<tr>
			<td>결혼</td>
			<td>
				<input type="radio" name="marriage" value="true" />예	
				<input type="radio" name="marriage" value="false" />아니오		
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="가입" /></td>
		</tr>
	</table>
</form>

</body>
</html>