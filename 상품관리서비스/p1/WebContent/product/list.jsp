<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set> <!-- root = requset.getContextPath() -->
<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>SSAFY-상품 목록</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		function movewrite() {
			location.href="${root}/main.do?act=mvinsert";
		}
		function movedelete() {
			location.href="${root}/main.do?act=mvremove";
		}
		function searchproduct() {
			if(document.getElementById("value").value == "") {
				alert("모든 목록 조회!!");
			}
			document.getElementById("searchform").action = "${root}/main.do";
			document.getElementById("searchform").submit();
		}
		</script>
	</head>
	<body>	
	<div class="container" align="center">
	  <div class="col-lg-8" align="center">
	  <h2>상품 목록</h2>  
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
	  			<button type="button" class="btn btn-link" onclick="javascript:movewrite();">상품 등록</button>
	  			<button type="button" class="btn btn-link" onclick="javascript:movedelete();">상품 삭제</button>
	  		</td>
	  	</tr>
	  </table>
	  <form id="searchform" method="get" class="form-inline" action="">
	  <input type="hidden" name="act" value="searchCondition">
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
		  	  <select class="form-control" name="key" id="key">
			    <option value="prod_name" selected="selected">상품명</option>
			    <option value="under_prod_price">다음 가격 이하</option>
			  </select>
			  <input type="text" class="form-control" placeholder="입력" name="value" id="value">
			  <button type="button" class="btn btn-primary" onclick="javascript:searchproduct();">검색</button>
			</td>
	  	</tr>
	  </table>
	  </form>
	  
	  <c:forEach var="product" items="${products}">
	  
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info">
	        <td>상품 이름 : ${product.prod_name}</td>
	        <td align="right">상품 번호 : ${product.prod_no}</td>
	      </tr>
	      <tr>
	        <td colspan="2" class="table-danger"><strong>상품 가격 : ${product.prod_price}</strong></td>
	      </tr>
	      <tr>
	        <td colspan="2">${product.prod_desc}</td>
	      </tr>
	    </tbody>
	  </table>
	  
	  </c:forEach>
	  </div>
	</div>
	</body>
</html>
