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
<title>imgBoard</title>
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
					<h6 class="m-0 font-weight-bold text-primary">이미지 게시판</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive" style="overflow: none;">
						<table class="table table-bordered" id="dataTable">
							<thead>
								<tr>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${imgList}">
									<li>
										<div style="text-align: center;">
										<div style="margin:0 25px 0 25px;">
											<a href="view?id=${list.id}"> 
												<img alt="" src="${root}${list.path}" style="width:300px;height:200px;margin-top:20px;" />
											</a>	
										</div>
											<div>${list.name}</div>
											<div><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${list.regdate}"/></div>
										</div>
									</li>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="layout/footer.jsp" />
</body>
</html>