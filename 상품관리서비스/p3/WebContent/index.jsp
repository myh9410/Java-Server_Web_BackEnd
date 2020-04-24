<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>SSAFY</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
<h2>메인 페이지</h2>
<c:if test="${userinfo eq null}"> <!-- if (memberDto == null) -->
		<h3>${msg}</h3>
		<%@ include file="/user/login.jsp" %> <!-- 파일의 내용을 copy -->
	</c:if> <!-- if문 종료 -->
	<c:if test="${userinfo != null}"> <!-- else문이 없으므로 조건 적어줘야됨 -->
	<div style="text-align: right; margin-right: 30px">
	<a>${userinfo.userid} 님 로그인 되었습니다.</a>
	<a class="nav-link" href="${root}/main.do?act=logout">로그아웃</a>
	</div>
	<a class="nav-link" href="${root}/main.do?act=mvphonereg">핸드폰 등록</a>
	<a class="nav-link" href="${root}/main.do?act=mvphonelist">핸드폰 목록</a>
	</c:if>
</div>
</body>
</html>