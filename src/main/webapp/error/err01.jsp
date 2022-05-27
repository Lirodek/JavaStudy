<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="../excep/excep02.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>err01</title>
</head>
<body>
<h1>err01</h1>
<%
	try{
		int a = 10/0;

		out.println("정상실행:"+ a);
	}catch(Exception e){
		out.println("에러가 발생했습니다.:"+ e.getMessage());
	}
	
	//// 1-> 20 까지 3,6,9 게임을 출력하세요
	//반복문은 사용가능 조건문 , 3항연산자 사용금지
	/*
	 1
	 2
	 짝
	 4
	 5
	 짝
	 7
	 8
	 짝
	---------------------
	10
	11
	12
	짝
	14
	15
	짝
	17
	18
	짝
	---------------------------
	20

	*/
	
	
	for(int i = 1; i <= 20 ; i++){
	
		int one = i%10;
		try{
			int three = one%3;
			int a = 1234/three;
			out.println("<br>"+i);
		}catch(Exception e){
			
			try{
				
				int a = 1234/ one;
				out.println("<br>짝");
			}catch(Exception e1){
				out.println("<br>"+i);
			}
			
		}
		
	}
	
	
%>

</body>
</html>