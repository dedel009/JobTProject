<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../view/layout/nav.jsp"/>
 <!-- Begin Page Content -->
                <div class="container-fluid" style="margin:0 auto;	">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">상세</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive" style="overflow:inherit;">
                            	<form action="detail" method="post">
	                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                                    <thead>
	                                        <tr>
	                                            <th>글번호</th>
	                                            <th>제목</th>
	                                            <th>내용</th>
	                                            <th>닉네임</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
											<tr>
												<td>${board.num}</td>
												<td>${board.title }</td>
												<td>${board.content }</td>
												<td>${board.nickname }</td>
											</tr>
	                                    </tbody>
	                                </table>
		     						<c:if test="${sessionScope.nickname == board.nickname}">
									<div style="float:right">
										<input type="submit" value="수정" name="cmd"/>
										<input type="submit" value="삭제" name="cmd"/>
									</div>
									</c:if>
                                </form>
							<a href="board" style="border:1px solid gainsboro; color: gray; border-radius: 10px;padding: 10px;">목록으로</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->	
	<jsp:include page="../view/layout/footer.jsp"/>
</body>
</html>