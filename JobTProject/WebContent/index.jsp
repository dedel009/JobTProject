<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main 화면</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
<link href="vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="css/landing-page.min.css" rel="stylesheet">
<style type="text/css">
.main_logo img:hover {
	background-color: buttonhighlight;
	border-radius: 20px;
	width: 200px;
}

.navbar-brand:hover {
	background-color: buttonhighlight;
	border-radius: 20px;
}

nav {
	background-color: lavender;
}
</style>
</head>
<body>
	<div class="wrap">
		<!-- Navigation -->
		<c:if test="${sessionScope.id == null }">
			<!-- Navigation -->
			<nav class="navbar navbar-light static-top bg-light"
				style="z-index: 80; position: fixed; width: 100%; opacity: 70%;">
				<div class="container">
					<a href="main" class="main_logo"><img
						src="/JobTProject/img/logo.png" alt="" style="width: 180px;"></a>
					<div>
						<a class="navbar-brand" href="content/imageBoard">이미지게시판</a> <a
							class="navbar-brand" href="#" onclick="fnMove('impormation')">설명</a>
						<a class="navbar-brand" href="#" onclick="fnMove('picture')">그림</a>
						<a class="navbar-brand" href="notice">공지사항</a> <a
							class="navbar-brand" href="board">자유게시판</a> <a
							class="btn btn-primary" href="user/login">로그인</a> <a
							class="btn btn-primary" href="user/signup">회원가입</a>
					</div>
				</div>
			</nav>
		</c:if>
		<c:if test="${sessionScope.id != null }">
			<nav class="navbar navbar-light static-top bg-light"
				style="z-index: 80; position: fixed; width: 100%; opacity: 70%;">
				<div class="container">
					<a href="main"><img src="/JobTProject/img/logo.png" alt=""
						style="width: 180px;" class="main_logo"></a>
					<div>
						<a class="navbar-brand" href="content/imageBoard">이미지게시판</a> <a
							class="navbar-brand" href="#" onclick="fnMove('impormation')">설명</a>
						<a class="navbar-brand" href="#" onclick="fnMove('picture')">그림</a>
						<a class="navbar-brand" href="notice">공지사항</a> <a class="navbar-brand"
							href="board">자유게시판</a> <a class="btn btn-primary"
							href="user/logout">로그아웃</a>
					</div>
				</div>
			</nav>
		</c:if>

		<!-- Masthead -->
		<header class="masthead text-white text-center"
			style="padding-top: 20rem; padding-bottom: 20rem; transition: top 0.2s ease-in-out;">
			<div class="overlay"
				style="background: url('img/connect.jpg'); background-size: cover; background-repeat: no-repeat; background-position: center; opacity: 100%;">
				<c:if test="${sessionScope.id == null }">
					<!-- Navigation -->
					<nav class="navbar navbar-ligh static-top hideme"
						style="z-index: 100; position: fixed; width: 100%; opacity: 100%; display: none;">
						<div class="container">
							<a href="main" class="main_logo"><img
								src="/JobTProject/img/logo.png" alt="" style="width: 180px;"></a>
							<div>
								<a class="navbar-brand" href="content/imageBoard">이미지게시판</a> <a
									class="navbar-brand" href="#" onclick="fnMove('impormation')">설명</a>
								<a class="navbar-brand" href="#" onclick="fnMove('picture')">그림</a>
								<a class="navbar-brand" href="notice">공지사항</a> <a
									class="navbar-brand" href="board">자유게시판</a> <a
									class="btn btn-primary" href="user/login">로그인</a> <a
									class="btn btn-primary" href="user/signup">회원가입</a>
							</div>
						</div>
					</nav>
				</c:if>
				<c:if test="${sessionScope.id != null }">
					<nav class="navbar navbar-light static-top hideme"
						style="z-index: 100; position: fixed; width: 100%; opacity: 100%; display: none;">
						<div class="container">
							<a href="main"><img src="/JobTProject/img/logo.png" alt=""
								style="width: 180px;" class="main_logo"></a>
							<div>
								<a class="navbar-brand" href="content/imageBoard">이미지게시판</a> <a
									class="navbar-brand" href="#" onclick="fnMove('impormation')">설명</a>
								<a class="navbar-brand" href="#" onclick="fnMove('picture')">그림</a>
								<a class="navbar-brand" href="notice">공지사항</a> <a
									class="navbar-brand" href="board">자유게시판</a> <a
									class="btn btn-primary" href="user/logout">로그아웃</a>
							</div>
						</div>
					</nav>
				</c:if>

				<div class="container">
					<div class="row">
						<div class="col-xl-9 mx-auto">
							<h1 class="mb-5" style="color: snow; line-height: 640px;">Everybody
								start job talking now!</h1>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!-- Icons Grid -->
		<section class="features-icons text-center"
			style="background-color: cornsilk;">
			<div class="overlay"></div>
			<div class="container">
				<div class="row">
					<div class="col-xl-9 mx-auto">
						<h1 class="mb-5">찾고있는 내용을 검색하세요!</h1>
					</div>
					<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
						<form action="totalSearch">
							<div class="form-row">
								<div class="col-12 col-md-9 mb-2 mb-md-0">
									<input type="text" name="query" class="form-control form-control-lg"
										placeholder="제목을 입력하시오.">
								</div>
								<div class="col-12 col-md-3">
									<button type="submit" class="btn btn-block btn-lg btn-primary">검색</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>

		<!-- Icons Grid -->
		<section class="features-icons bg-light text-center">
			<div class="container impormation">
				<div class="row">
					<div class="col-lg-4">
						<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
							<div class="features-icons-icon d-flex">
								<i class="icon-screen-desktop m-auto text-primary"></i>
							</div>
							<h3>어디서든</h3>
							<p class="lead mb-0">This theme will look great on any
								device, no matter the size!</p>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
							<div class="features-icons-icon d-flex">
								<i class="icon-layers m-auto text-primary"></i>
							</div>
							<h3>다양한 후기를</h3>
							<p class="lead mb-0">Featuring the latest build of the new
								Bootstrap 4 framework!</p>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="features-icons-item mx-auto mb-0 mb-lg-3">
							<div class="features-icons-icon d-flex">
								<i class="icon-check m-auto text-primary"></i>
							</div>
							<h3>쉽게 사용하세요</h3>
							<p class="lead mb-0">Ready to use with your own content, or
								customize the source files!</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- Image Showcases -->
		<section class="showcase">
			<div class="container-fluid p-0 ">
				<div class="row no-gutters">

					<div class="col-lg-6 order-lg-2 text-white showcase-img picture"
						style="background-image: url('img/where.jpg'); background-position: center;"></div>
					<div class="col-lg-6 order-lg-1 my-auto showcase-text">
						<h2>어디서든</h2>
						<p class="lead mb-0">When you use a theme created by Start
							Bootstrap, you know that the theme will look great on any device,
							whether it's a phone, tablet, or desktop the page will behave
							responsively!</p>
					</div>
				</div>
				<div class="row no-gutters">
					<div class="col-lg-6 text-white showcase-img"
						style="background-image: url('img/feedback.jpg'); background-position: center;"></div>
					<div class="col-lg-6 my-auto showcase-text">
						<h2>다양한 후기를</h2>
						<p class="lead mb-0">Newly improved, and full of great utility
							classes, Bootstrap 4 is leading the way in mobile responsive web
							development! All of the themes on Start Bootstrap are now using
							Bootstrap 4!</p>
					</div>
				</div>
				<div class="row no-gutters">
					<div class="col-lg-6 order-lg-2 text-white showcase-img"
						style="background-image: url('img/impossible.jpg'); background-position: center;"></div>
					<div class="col-lg-6 order-lg-1 my-auto showcase-text">
						<h2>쉽게 사용하세요 &amp; Customize</h2>
						<p class="lead mb-0">Landing Page is just HTML and CSS with a
							splash of SCSS for users who demand some deeper customization
							options. Out of the box, just add your content and images, and
							your new landing page will be ready to go!</p>
					</div>
				</div>
			</div>
		</section>
		<jsp:include page="WEB-INF/view/layout/footer.jsp" />
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="js/user/index.js?ver=1"></script>
</body>
</html>