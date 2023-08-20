<%@page import="jdbc_p.MemberDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="jdbc_p.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="dto" class="jdbc_p.MemberDTO"/>
<jsp:setProperty property="*" name="dto"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
<h1>로그인 처리</h1>
<%
	MemberDTO mmm = new MemberDAO().detail(dto);
	System.out.println("logReg:"+mmm);
	String msg = "로그인 실패";
	
	if( mmm != null ){
		msg = "로그인 성공";

		session.setAttribute("inUser", mmm);
	}
	
	/* 
	HashMap<String, MemberDTO> mems = new HashMap();
	mems.put("",new MemberDTO());
	
	mems.put("aaa",new MemberDTO("aaa","1111","장동건"));
	  mems.put("bbb",new MemberDTO("bbb","2222","장서건"));
	  mems.put("ccc",new MemberDTO("ccc","3333","장남건"));
	  mems.put("ddd",new MemberDTO("ddd","4444","장중건"));
	  mems.put("eee",new MemberDTO("eee","3333","북두신건"));
	  
	  
	  String pid = request.getParameter("pid");
	  String msg = "로그인 실패";
	if(mems.containsKey(pid)){
		
		MemberDTO dto = mems.get(pid);
			
		if(dto.getPw().equals( request.getParameter("pw") ) ){
			msg = "로그인 성공";
			
			
			session.setAttribute("inUser", dto);
		}
		
	} */

	
%>

<script>
	alert("<%=msg%>");
	location.href = "main.jsp";
</script>

</body>
</html>