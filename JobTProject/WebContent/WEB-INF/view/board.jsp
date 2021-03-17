<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<jsp:include page="../view/layout/nav.jsp"/>
	<table border=1>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>시간</th>
			<th>닉네임</th>
		</tr>
		<c:forEach var="list" items="${list}">
		<tr>
			<td>${list.num}</td>
			<td><a href="detail?num=${list.num}">${list.title }</a></td>
			<td>${list.regdate }</td>
			<td>${list.nickname }</td>
		</tr>
		</c:forEach>
	</table>
	<c:if test="${not empty sessionScope.id}">
		<a href="insert?n=${sessionScope.nickname}">추가</a>	
	</c:if>
</body>
</html>