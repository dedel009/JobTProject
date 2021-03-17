<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../view/layout/nav.jsp"/>
	<form action="detail" method="post">
		<table border=1>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>닉넴</th>
			</tr>
			<tr>
				<td>${board.num}</td>
				<td>${board.title }</td>
				<td>${board.content }</td>
				<td>${board.nickname }</td>
			</tr>
		</table>
		<c:if test="${sessionScope.nickname == board.nickname}">
			<input type="submit" value="수정" name="cmd"/>
			<input type="submit" value="삭제" name="cmd"/>
		</c:if>
	</form>
	<a href="board">목록으로</a>
</body>
</html>