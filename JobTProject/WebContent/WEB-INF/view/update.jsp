<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
		<p>글번호 : ${board.num}</p>
		<p>닉넴: ${board.nickname }</p> 
		<input type="text" name="title" value="${board.title }"/>
		<textarea rows="" cols="" name="content">${board.content }</textarea>
		<input type="submit" value="수정하기">
	</form>
	<a href="board">수정취소</a>
</body>
</html>