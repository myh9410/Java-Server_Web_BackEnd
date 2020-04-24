<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>핸드폰 관리</title>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<div style="text-align: right; margin-right: 30px">
<c:if test="${userinfo != null}"> <!-- else문이 없으므로 조건 적어줘야됨 -->
<a>${userinfo.userid} 님 로그인 되었습니다.</a>
<a class="nav-link" href="${root}/main.do?act=logout">로그아웃</a>
</c:if>
</div>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 핸드폰 조회</b></td>
		  </tr>
	  </table>  
	  <br>
	  <form method="POST" action="${root}/main.do?act=remove">
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모델번호</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모델이름</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">가격</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">제조사명</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">삭제</td>
		  </tr>
		  <c:forEach var="phone" items = "${phones}">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">${phone.num}</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">${phone.model}</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">${phone.price}</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">${phone.vcode}</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22"><input type="checkbox" name="checker" value= ${phone.num}></td>
		  </tr>
		  </c:forEach>
	  </table>
	  <br>
	  <div class="container">
	  <ul class="nav" style="align-content: center;">
	 	<li class="nav-item">
			<a class="nav-link" href="${root}/main.do?act=mvphonereg">추가 등록</a>
		</li>
		<li class="nav-item">
			<input type="submit" value="선택항목 삭제">
		</li>
		</ul>
	  </div>
	  </form>
	  </td>
	</tr>
</table>  

</body>

</html>