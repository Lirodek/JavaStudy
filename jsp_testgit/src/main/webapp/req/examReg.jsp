<%@page import="bas.StudDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	request.setCharacterEncoding("utf-8");
    
    	ArrayList<StudDTO> studs = new ArrayList();
    	
    	String [] names = request.getParameterValues("pname");
    	String [] kor = request.getParameterValues("kor");
    	String [] eng = request.getParameterValues("eng");
    	String [] mat = request.getParameterValues("mat");
    	
    	for(int i = 0; i<names.length;i++){
    		StudDTO dto = new StudDTO(names[i]
    				,kor[i],eng[i],mat[i]);
    		studs.add(dto);
    	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>examReg</title>
<link href="../css/examForm.css" rel="stylesheet">
</head>
<body>
<h1>examReg</h1>
<% for(StudDTO st: studs){ %>
<%=st.getDiv() %>
<%} %>
</body>
</html>