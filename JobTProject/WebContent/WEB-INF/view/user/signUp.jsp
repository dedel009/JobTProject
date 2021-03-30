<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
    .wrap {
        width: 1200px;
        margin: 0 auto;
    }
	.div{
		width:360px;
	}
    div{
        text-align: center;
    }
    table{
    	margin:0 auto;
    }
    input{
    	width:100%;
    }
</style>
<link href="${root}/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
	<div class="wrap">
        <nav>
            <div>
                <a href="${root}/main"><img src="${root}/img/logo.png" alt="" style="width:500px;"></a>
            </div>
        </nav>
		<form action="signup" method="post" class="form">
			<div>
			<table>
				<tr>
					<td><div class="div"><input type="text" name="id" class="id" maxlength="20" value="${id}" placeholder="아이디" required></div></td>
				</tr>
				<tr>
					<td>
						<c:if test="${idCheck==1}">
							<p class="p1 no1" style="color:red; margin:0; ">이미 있는 아이디입니다.</p>
						</c:if>	
						<c:if test="${idCheck==0}">
							<p class="p1 yes1" style="color:green; margin:0;">아주 멋진 아이디군요.</p>
						</c:if>	
						<p class="p1 nono1" style="color:red; margin:0; display:none;">필수 정보입니다.</p>
					</td>				
				</tr>
				<tr>
					<td><div class="div"><input type="password" class="password" name="password" maxlength="15" value="${password}" placeholder="비밀번호" required></div></td>
				</tr>
				<tr>
					<td>				
						<p class="no2" style="color:red; margin:0; display: none;">8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.</p>							
						<p class="yes2" style="color:green; margin:0; display: none; ">안전</p>							
						<p class="nono2" style="color:red; margin:0; display: none;">필수 정보입니다.</p>						
					</td>
				</tr>
				<tr>
					<td><div class="div"><input type="password" class="passwordcheck" name="passwordcheck" maxlength="15" value="${passwordcheck }" placeholder="비밀번호 확인" required></div></td>
				</tr>
				<tr>
					<td>
						<p class="no3" style="color:red; margin:0; display: none;">불일치</p>							
						<p class="yes3" style="color:green; margin:0; display: none; ">일치</p>							
						<p class="nono3" style="color:red; margin:0; display: none;">필수 정보입니다.</p>					
					</td>
				</tr>
				<tr>
					<td><div class="div"><input type="text" class="name" name="name" maxlength="10" value="${name}" placeholder="이름" required></div></td>
				</tr>
				<tr>
					<td>
						<p class="nono4" style="color:red; margin:0; display: none;">필수 정보입니다.</p>						
					</td>
				</tr>
				<tr>
					<td><div class="div"><input type="text" class="nickname" name="nickname" maxlength="20" value="${nickname}" placeholder="닉네임" required></div></td>
				</tr>
				<tr>
					<td>
						<p class="nono5" style="color:red; margin:0; display: none;">필수 정보입니다.</p>						
					</td>
				</tr>
			</table>
			</div>
			<input type="submit" value="가입" style="width:30%;"/>
		</form>
		<p style="color:red;">${message}</p>
	</div>
	<script type="text/javascript" src="${root}/js/user/signUp.js?ver=1"></script>
</body>
</html>