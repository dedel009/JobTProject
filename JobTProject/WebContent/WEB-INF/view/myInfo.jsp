<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
								<td colspan="3"><div style="color: blue; font-weight: bold;"><span style="color:green;">${id}</span>님의 회원정보입니다.</div></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="width:200px;">이름</td>
								<td colspan="2">
									<div>${member.name}</div>
									<div style="color:green;">이름이 변경되었다면 수정을 통해 변경할 수 있습니다.</div>
									<div><input type="submit" value="수정" /></div>
								</td>
							</tr>
							<tr>
								<td style="line-height: 50px;">닉네임</td>
								<td colspan="2">
									<div>${member.nickname}</div>
									<div style="color:green;">닉네임을 변경하고 싶은 경우 수정을 통해 닉네임을 변경할 수 있습니다.</div>
									<div><input type="submit" value="수정" /></div>
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td>
									<div>${member.email}</div>
									<div style="color:red;">후기 게시판에 글을 작성하려면 회사 이메일을 인증해주세요.</div>
								</td>
	
								<td style="width:170px;"><input type="submit" value="이메일인증" /></td>
							</tr>
							<tr>
								<td>가입한 날짜</td>
								<td colspan="2">
									<div style="color:hotpink;">이때부터군요 저희의 인연은</div>
									<div><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${member.regdate}"/></div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="../view/layout/footer.jsp" />
</body>
</html>