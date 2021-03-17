<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>img detail</title>
</head>
<body>

	<table border=1>
		<tr>
			<td rowspan="2"><img alt="" src="${root}${listdetail.path}">
			</td>
			<td>${listdetail.name}</td>
		</tr>
		<tr>
			<td>평점: ${avg}</td>
		</tr>
	</table>
	<a href="imageBoard">이미지게시판으로</a>
	<br>
	<br>
	<c:if test="${count!=0}">
	<table border=1>
		<c:forEach var="clist" items="${cd}">
		<tr>
			<td>${clist.userID}</td>
			<td>${clist.regdate}</td>
		</tr>
		<tr>
			<td>${clist.comment}</td>
			<td>${clist.score}</td>				
		</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${count==0 }">
		<h3>댓글입력하시오</h3>
	</c:if>
	<form action="" method="post">
		<div class="comment">
			<input type="text" name="comment" />
			<select name="score">
				<option ${(param.s=="5")?"selected":""} value="5">5</option>
				<option ${(param.s=="4")?"selected":""} value="4">4</option>
				<option ${(param.s=="3")?"selected":""} value="3">3</option>
				<option ${(param.s=="2")?"selected":""} value="2">2</option>
				<option ${(param.s=="1")?"selected":""} value="1">1</option>																
			</select>
		</div>
		
		<input type="submit" value="입력" >
	</form>
</body>
</html>