<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String fName = request.getParameter("fName"); 
	
	
	String en =URLEncoder.encode(fName,"utf-8");
	response.setHeader("Content-Disposition", "attachment; filename="+en);

	out.clear();
	out = pageContext.pushBody();

	String path = request.getRealPath("fff");
	path = "D:\\public\\green\\2022_04\\503_study\\jsp_work\\jspProj\\src\\main\\webapp\\fff";
	path += "\\"+fName;
	
	FileInputStream fis = new FileInputStream(path);
	ServletOutputStream sos = response.getOutputStream();
	
	byte [] buf = new byte[1024];
	
	while(fis.available()>0){
		int len = fis.read(buf);
		sos.write(buf,0,len);
	}
	
	
	sos.close();
	fis.close();

%>