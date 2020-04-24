<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
  <title>SSAFY-상품 등록</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function writeProduct() {
	if(document.getElementById("prod_name").value == "") {
		alert("제목 입력!!!!");
		return;
	} else if(document.getElementById("prod_price").value == "") {
		alert("가격 입력!!!!");
		return;
	} else if(document.getElementById("prod_desc").value == "") {
		alert("설명 입력!!!!");
		return;
	} else {
	  	document.getElementById("writeform").action = "${root}/main.do";
	  	document.getElementById("writeform").submit();
	}
  }
  function moveWrite() {
		document.location.href = "${root}/main.do?act=mvinsert";
	}
  </script>
</head>
<body>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>상품 등록</h2>
		<form id="writeform" method="post" action="">
		<input type="hidden" name="act" value="insert">
			<div class="form-group" align="left">
				<label for="subject">상품 명:</label>
				<input type="text" class="form-control" id="prod_name" name="prod_name">
			</div>
			<div class="form-group" align="left">
				<label for="subject">상품 가격:</label>
				<input type="text" class="form-control" id="prod_price" name="prod_price">
			</div>
			<div class="form-group" align="left">
				<label for="content">상품 설명:</label>
				<textarea class="form-control" rows="15" id="prod_desc" name="prod_desc"></textarea>
			</div>
			<button type="button" class="btn btn-primary" onclick="javascript:writeProduct();">상품 등록</button>
			<button type="reset" class="btn btn-warning">초기화</button>
		</form>
	</div>
</div>
</body>
</html>