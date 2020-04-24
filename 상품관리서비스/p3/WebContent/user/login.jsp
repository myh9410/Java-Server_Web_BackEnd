<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set> <!-- root = requset.getContextPath() -->
<c:if test="${cookie.ssafy_id.value}">
	<c:set var="svid" value="${cookie.ssafy_id.value}"/>
	<c:set var="ckid" value="checked"/>
</c:if>

<script type="text/javascript">
function login() {
	if(document.getElementById("userid").value == "") {
		alert("아이디 입력!!!");
		return;
	} else if(document.getElementById("userpwd").value == "") {
		alert("비밀번호 입력!!!");
		return;
	} else {
		document.getElementById("loginform").action = "${root}/main.do?act=login";
		//<input type="hidden" name="act" value="login">아래의 아이디, 비밀번호 등의 값들을 넘겨줌
		document.getElementById("loginform").submit();
	}
}
</script>
</head>
<body>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<form id="loginform" method="post" action="">
		<h4>로그인하여 주세요</h4>
		<input type="hidden" name="act" value="login">
			<div class="form-group" align="left">
				<label for="">ID</label>
				<input type="text" class="form-control" id="userid" name="userid" placeholder="" value="${svid}">
			</div>
			<div class="form-group" align="left">
				<label for="">PASSWORD</label>
				<input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="" onkeydown="javascript:if(event.keyCode == 13) {login();}">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" onclick="javascript:login();">로그인</button>
			</div>
		</form>
		<a class="nav-link" href="${root}/main.do?act=mvphonereg">핸드폰 등록</a>
		<a class="nav-link" href="${root}/main.do?act=mvphonelist">핸드폰 목록</a>
	</div>
</div>
