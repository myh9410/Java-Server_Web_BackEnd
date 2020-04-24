<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
  <title>SSAFY-상품 삭제</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function removeProduct() {
	if(document.getElementById("prod_name").value == "") {
		alert("상품명 입력!!!!");
		return;
	} else {
		alert("삭제 완료!");
	  	document.getElementById("writeform").action = "${root}/main.do";
	  	document.getElementById("writeform").submit();
	}
  }
  </script>
</head>
<body>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>삭제할 상품명 등록</h2>
		<form id="writeform" method="post" action="">
		<input type="hidden" name="act" value="remove">
			<div class="form-group" align="left">
				<label for="subject">상품 명:</label>
				<input type="text" class="form-control" id="prod_name" name="prod_name">
			</div>
			<button type="button" class="btn btn-primary" onclick="javascript:removeProduct();">상품 삭제</button>
			<button type="reset" class="btn btn-warning">초기화</button>
		</form>
	</div>
</div>
</body>
</html>