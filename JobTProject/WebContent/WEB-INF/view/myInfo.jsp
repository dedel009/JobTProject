<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<style>
.wrap {
	width: 1200px;
	margin: 0 auto;
}

div {
	text-align: center;
}

.div {
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<jsp:include page="../view/layout/nav.jsp" />
	<div class="wrap">
		<form action="#" method="post" class="form">
			<div class="card-body">
				<div class="table-responsive" style="overflow: none;">
					<table class="table table-bordered" id="dataTable">
						<thead>
							<tr>
								<td colspan="3"><p style="color: blue; font-weight: bold;">회원정보</p></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>아이디</td>
								<td colspan="2">${id}</td>
							
							</tr>
							<tr>
								<td>이름</td>
								<td colspan="2">${name}</td>
							</tr>
							<tr>
								<td>닉네임</td>
								<td colspan="2">${nickname}</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td>${email}</td>
								<td style="width:170px;"><input type="submit" value="이메일인증" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<input type="submit" value="회원정보수정" style="width: 10%;" />
		</form>
	</div>
	<jsp:include page="../view/layout/footer.jsp" />
</body>
</html>