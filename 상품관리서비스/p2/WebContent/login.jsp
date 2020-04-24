<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.SsafyMember"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
<%
Cookie [] cookies = request.getCookies();
SsafyMember dto = (SsafyMember) session.getAttribute("loginVO");
if(dto != null && dto.getUserid() != null && !dto.getUserid().trim().equals("")){//로그인 한 상태
%>
	<%= dto.getUserid() %>님 환영합니다.
<!-- 	<br> <a href="./Logout">로그아웃</a> -->
	<br> <a href="./LoginController?command=logout">로그아웃</a>
	<br> <%= cookies[0].getName() %> : <%= cookies[0].getValue() %>
	<br> <%= cookies[1].getName() %> : <%= cookies[1].getValue() %>
	<br> <%= cookies[2].getName() %> : <%= cookies[2].getValue() %>
	<br> <%= cookies[3].getName() %> : <%= cookies[3].getValue() %>
<%	
} else {//로그인 안한 상태
%>
<!-- 	<form action="./Login"> -->
	<form action="./LoginController">
		<input type="text" id="" name="command" value="login">
		<br>
		ID : <input type="text" id="" name="id_from_view">
		<br>
		PWD : <input type="text" id="" name="pwd_from_view">
		<br>
		<input type="submit" value="전송">
	</form>
<%
}
%>
</body>
</html>
