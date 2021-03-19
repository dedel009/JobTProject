<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>nav</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="css/landing-page.min.css" rel="stylesheet">
  <style type="text/css">
	.main_logo img:hover{
		background-color: buttonhighlight;
		border-radius:20px;
		width:200px;
	}
	
	.navbar-brand:hover{
		background-color: buttonhighlight;
		border-radius:20px;		
	}
  </style>
</head>
<body>
	<c:if test="${sessionScope.id == null }">
	  <!-- Navigation -->
	  <nav class="navbar navbar-light bg-light static-top">
	    <div class="container">
          <a href="main" class="main_logo"><img src="/JobTProject/img/logo.png" alt="" style="width:180px;"></a>
          <div>
  	      	  <a class="navbar-brand" href="#">공지사항</a> 
  	      	  <a class="navbar-brand" href="#">공지사항</a>           
  	      	  <a class="navbar-brand" href="#">공지사항</a>        
	      	  <a class="navbar-brand" href="board">자유게시판</a>
		      <a class="btn btn-primary" href="user/login">로그인</a>
		      <a class="btn btn-primary" href="user/signup">회원가입</a>
	      </div>
	    </div>
	  </nav>
	</c:if>
	
	<c:if test="${sessionScope.id != null }">
	<nav class="navbar navbar-light bg-light static-top">
	    <div class="container">
          <a href="main"><img src="/JobTProject/img/logo.png" alt="" style="width:180px;"></a>
          <div>
  	      	  <a class="navbar-brand" href="#">공지사항</a> 
	      	  <a class="navbar-brand" href="board">자유게시판</a>
		      <a class="btn btn-primary" href="user/logout">로그아웃</a>
	      </div>
	    </div>
	  </nav>       
	</c:if>
	<script type="text/javascript">
	window.onload = function(){
	    if (self.name != 'reload') {
	        self.name = 'reload';
	        self.location.reload(true);
	    }
	    else self.name = ''; 
	}
	</script>
</body>
</html>