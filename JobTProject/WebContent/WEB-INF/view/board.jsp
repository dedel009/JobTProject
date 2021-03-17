<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../view/layout/nav.jsp"/>
 <!-- Begin Page Content -->
                <div class="container-fluid" style="margin:0 auto;	">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">자유게시판</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive" style="overflow:none; ">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>글번호</th>
                                            <th>제목</th>
                                            <th>시간</th>
                                            <th>닉네임</th>
                                        </tr>
                                    </thead>
                                    <tbody>
								      	<c:forEach var="list" items="${list}">
											<tr>
												<td>${list.num}</td>
												<td><a href="detail?num=${list.num}">${list.title }</a></td>
												<td>${list.regdate }</td>
												<td>${list.nickname }</td>
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                                <c:if test="${not empty sessionScope.id}">
									<a href="insert?n=${sessionScope.nickname}" style="border:1px solid gainsboro; color: gray; border-radius: 10px;padding: 10px;">추가</a>	
								</c:if>
								<!-- 페이징 처리 -->	
								<c:set var="page" value="${empty param?1:param.p}"></c:set>	
								<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
								<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/7), '.')}"></c:set>
								<hr style="clear: both; border:none;">
								<div style="width:200px;text-align: center; margin:0 auto;">
									<!-- 이전 -->
									<c:if test="${startNum > 1}">
										<div style="float:left;">
											<a href="?p=${startNum-1}">이전</a>
										</div>
									</c:if>
									<c:if test="${startNum <= 1}">
										<div style="float:left;">
											<a href="#" onclick="alert('first page')">이전</a>
										</div>										
									</c:if>				
									
									<c:forEach var="page" begin="0" end="${lastNum-1}">
									<div style="float:left; margin:0px 10px 0px 10px;">
										<a href="?p=${startNum+page}">${startNum+page }</a>
									</div>
									</c:forEach>

									
									<!-- 다음 -->
									<c:if test="${startNum+5 > lastNum}">
										<div style="float:left;">
											<a href="#" onclick="alert('last page')">다음</a>
										</div>
									</c:if>
									<c:if test="${startNum+5 <= lastNum}">
										<div style="float:left;">
											<a href="?p=${startNum+(lastNum-1)}">다음</a>
										</div>
									</c:if>										
								</div>	
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->	
	<jsp:include page="../view/layout/footer.jsp"/>
</body>
</html>