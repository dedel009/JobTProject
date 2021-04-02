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
<link href="${root}/css/sb-admin-2.min.css" rel="stylesheet">
<link href="${root}/css/style.css" rel="stylesheet">
<style type="text/css">
li {
	list-style-type: none;
	float: left;
	margin-left: 10px;
}

.wrap {
	width: 1200px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<jsp:include page="layout/nav.jsp" />
	<div class="wrap">
		<div class="container-fluid" style="margin: 20px auto;">
			<!-- DataTales Example -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">상세 이미지 게시판</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive" style="overflow: none;">
						<table class="table table-bordered" id="dataTable">
							<thead>
								<tr>
									<th>${listdetail.name}</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><img alt="" src="${root}${listdetail.path}"
										style="width: 800px;"></td>
								</tr>
								<tr>
									<td><span style="color:green; font-size:35px; font-weight: bold;">평점: ${avg}</span></td>
								</tr>
							</tbody>
						</table>
						<div style="text-align: center;">
							<c:if test="${count!=0}">
								<table class="table table-bordered" id="dataTable">
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
									<input type="text" name="comment" /> <select name="score">
										<option ${(param.s=="5")?"selected":""} value="5">5</option>
										<option ${(param.s=="4")?"selected":""} value="4">4</option>
										<option ${(param.s=="3")?"selected":""} value="3">3</option>
										<option ${(param.s=="2")?"selected":""} value="2">2</option>
										<option ${(param.s=="1")?"selected":""} value="1">1</option>
									</select>
									<c:if test="${not empty sessionScope.id}">
										<input type="submit" value="입력">								
									</c:if>
									<c:if test="${empty sessionScope.id}">
										<input type="button" value="입력" onclick="alert('로그인을 해주세요!');">								
									</c:if>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="layout/footer.jsp" />
</body>
</html>