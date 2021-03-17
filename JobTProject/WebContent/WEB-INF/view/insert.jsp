<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../view/layout/nav.jsp"/>
	<form action="insert" method="post">
		닉넴:${sessionScope.nickname}
		제목:<input type="text" name="title"/>
		내용:<textarea rows="" cols="" name="content"></textarea>
		
		<input type="submit" value="글쓰기" />
	</form>
</body>
</html>