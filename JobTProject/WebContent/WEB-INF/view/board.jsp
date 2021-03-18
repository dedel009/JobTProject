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
<link href="css/style.css" rel="stylesheet">
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
	                            <div style="width:100%; text-align: center;">
	                            	<form action="?p=${empty param.p?1:param.p}" method="post">
		                            	<select name="field">
		                            		<option ${(param.field=="title")?"selected":""} value="title">제목</option>
		                            		<option ${(param.field=="nickname")?"selected":""} value="nickname">닉네임</option>
		                            	</select>
		                            	<input type="text" name="query" value="${param.query}" />
		                            	<input type="submit" value="검색">
	                            	</form>
	                            </div>
                                <c:if test="${not empty sessionScope.id}">
									<a href="insert?n=${sessionScope.nickname}" style="border:1px solid gainsboro; color: gray; border-radius: 10px;padding: 10px;">글쓰기</a>	
								</c:if>
								<!-- 페이징 처리 -->	
								<c:set var="p" value="${empty param?1:param.p}"></c:set>	
								<c:set var="startNum" value="${p-(p-1)%5}"></c:set>
								<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/7), '.')}"></c:set>
								<hr style="clear: both; border:none;">
								<div style="width:215px;text-align: center; margin:0 auto;">
									<!-- 이전 -->
									<c:if test="${startNum > 1}">
										<div style="float:left;">
											<a href="?p=${startNum-1}">이전</a>
										</div>
									</c:if>
									<c:if test="${startNum <= 1}">
										
									</c:if>				
									
									<c:forEach var="page" begin="0" end="4">
										<c:if test="${page<lastNum}">
											<div style="float:left; margin:0px 10px 0px 10px;">
												<a href="?p=${startNum+page}&query=${param.query}&field=${param.field}" class="page_a">${startNum+page }</a>
											</div>
										</c:if>
									</c:forEach>
									
									<!-- 다음 -->
									<c:if test="${startNum+5 > lastNum}">

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