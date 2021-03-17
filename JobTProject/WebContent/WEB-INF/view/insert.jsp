<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                            <h6 class="m-0 font-weight-bold text-primary">수정</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive" style="overflow:none; ">
								<form action="insert" method="post">
	                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <tr>
                                            <th>닉네임 : ${sessionScope.nickname}</th>
                                        </tr>
                                        <tr>
                                        	<td colspan="2"><input type="text" name="title" style="border:none; width:100%;"/></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><textarea  name="content" style="border:none; width:100%;"></textarea></td>
                                        </tr>
	                                </table>
	                                <input type="submit" value="글쓰기" style="float:right;">
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