<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>imgBoard</title>
<style type="text/css">
	ul{
		list-style-type: none;
	}
	li{
		float:left;
		margin-left : 10px;
	}
	body{
		width:1920px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<ul>
		<c:forEach var="list" items="${imgList}">
		<li>
			<a href="view?id=${list.id}">
				<img alt="" src="${root}${list.path}"/>
			</a>
			<div>${list.name}</div>
			<div>${list.regdate}</div>
		</li>
		</c:forEach>
	</ul>
</body>
</html>