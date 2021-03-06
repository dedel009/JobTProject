<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세부 공지사항</title>
</head>
<body>
	<jsp:include page="../view/layout/nav.jsp"/>
 <!-- Begin Page Content -->
                <div class="container-fluid" style="margin:20px auto;	">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4" style="width:1200px; margin:0 auto;">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">상세</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive" style="overflow:inherit;">
                            	<form action="noticeUpdate?place=${place}" method="post">
	                               	<table class="table table-bordered" id="dataTable" >
	                                    <tbody>
	                                    	<tr>
	                                   			<td colspan="3">${nt.title }</td> 	
	                                    	</tr>
											<tr>
												<td>${nt.num}</td>
												<td><fmt:formatDate pattern="yyyy.MM.dd hh:mm" value="${nt.regdate}"/></td>
												<td>${nt.nickname }</td>
											</tr>
											<tr>
												<td colspan="3" style="height:400px;">${nt.content }</td>
											</tr>
	                                    </tbody>
	                                </table>
	<!--                                	<input type="hidden" name="place" value="notice"> -->
		     						<c:if test="${sessionScope.nickname == nt.nickname}">
									<div style="float:right">
										<input type="submit" value="수정" name="cmd"/>
										<input type="submit" value="삭제" name="cmd"/>
									</div>
									</c:if>
                                </form>
							<a href="#" style="border:1px solid gainsboro; color: gray; border-radius: 10px;padding: 10px;" onclick="location.href='notice'">목록으로</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->	
	<jsp:include page="../view/layout/footer.jsp"/>
</body>
</html>