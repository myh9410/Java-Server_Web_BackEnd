<%@page import="dto.SsafyMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>insert_product</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<% SsafyMember dto = (SsafyMember) session.getAttribute("loginVO");
if (dto != null && dto.getUserid() != null && !dto.getUserid().trim().equals("")){
%>
	<%= dto.getUserid() %>님 환영합니다.
	<br> <a href="./LoginController?command=logout">로그아웃</a>
	<br>
<%
}
%>
	<form class="col-xl-4 col-sm-4 col-4" method="get" action="./ProductController">
		<input type="hidden" id="" name="command" value="prdt_ins">
	  <div class="form-group">
	    <label for="name">상품명 : </label>
	    <input type="text" class="form-control" placeholder="Enter name" id="" name="prdt_name">
	  </div>
	  <div class="form-group">
	    <label for="price">상품가격 : </label>
	    <input type="text" class="form-control" placeholder="Enter price" id="" name="prdt_price">
	  </div>
	  <div class="form-group">
	    <label for="desc">상품설명 : </label>
	    <input type="text" class="form-control" placeholder="Enter desc" id="" name="prdt_desc">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	  <button type="reset" class="btn btn-primary">Reset</button>
	</form> 
</body>
</html>
    