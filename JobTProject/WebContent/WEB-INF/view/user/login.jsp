<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
    <nav>
        <div>
            <a href="/JobTProject/main"><img src="/JobTProject/img/logo.png" alt="" style="width:200px;"></a>
            <a href="/JobTProject/board">게시판</a>
        </div>
    </nav>
	<form action="login" method="post">
		<div>
			id : <input type="text" name="id" required/>
		</div>
		<div>
			pass : <input type="text" name="password" required/>
		</div>
		<input type="submit" value="로그인" /> <a href="signup">회원가입</a>
	</form>
</body>
</html>