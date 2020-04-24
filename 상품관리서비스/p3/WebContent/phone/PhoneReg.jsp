<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>핸드폰 관리</title>
<script type="text/javascript">
function cancel() {
	location.href="${root}/main.do?act=cancel";
}
</script>
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
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 핸드폰 등록</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <!-- write Form  -->
	  <form method="post" action="${pageContext.request.contextPath}/main.do?act=phonereg">
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모델번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:150" name="num"/>  
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모 델 명</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:150" name="model"/>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;격</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="price"/>원
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">제 조 사</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				<select NAME="vcode" id="vcode" tabindex="5"  style="width:90px">
				<option value="10">삼성</option>
				<option value="20">엘지</option>
				<option value="30">애플</option>
				</select>
			</td>
		  </tr>		  
	  </table>

	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="submit" value="핸드폰 등록"/> &nbsp;
			<input type="reset" value="취소" onclick="javascript:cancel();"> &nbsp;
			</td>
		  </tr>
	  </table>
	  <input type="hidden" name="action" value="SAVE"/>
	  </form>
	  </td>
	</tr>
</table>  

</body>

</html>