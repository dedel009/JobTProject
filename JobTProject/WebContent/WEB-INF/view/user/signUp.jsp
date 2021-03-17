<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div id="wrap">
		<a href="../main"><img alt="" src="/JobTProject/img/logo.png"
			style="width: 200px;"></a> <br> <br> <b><font
			size="6" color="gray">회원가입</font></b> <br> <br> <br>

		<form action="signup" method="post" class="form">
			<table>
				<tr>
					<td id="title">아이디</td>
					<td><input type="text" name="id" class="id" maxlength="20" value="${id}" required></td>
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
					<td id="title">비밀번호</td>
					<td><input type="password" class="password" name="password" maxlength="15" value="${password}" required></td>
					<td>				
						<p class="no2" style="color:red; margin:0; display: none;">8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.</p>							
						<p class="yes2" style="color:green; margin:0; display: none; ">안전</p>							
						<p class="nono2" style="color:red; margin:0; display: none;">필수 정보입니다.</p>						
					</td>
				</tr>
				<tr>
					<td id="title">비밀번호 확인</td>
					<td><input type="password" class="passwordcheck" name="passwordcheck" maxlength="15" value="${passwordcheck }" required></td>
					<td>
						<p class="no3" style="color:red; margin:0; display: none;">불일치</p>							
						<p class="yes3" style="color:green; margin:0; display: none; ">일치</p>							
						<p class="nono3" style="color:red; margin:0; display: none;">필수 정보입니다.</p>					
					</td>
				</tr>
				<tr>
					<td id="title">이름</td>
					<td><input type="text" class="name" name="name" maxlength="10" required></td>
					<td>
						<p class="nono4" style="color:red; margin:0; display: none;">필수 정보입니다.</p>						
					</td>
				</tr>
				<tr>
					<td id="title">닉네임</td>
					<td><input type="text" class="nickname" name="nickname" maxlength="20" required></td>
					<td>
						<p class="nono5" style="color:red; margin:0; display: none;">필수 정보입니다.</p>						
					</td>
				</tr>
			</table>
			<br> <input type="submit" value="가입" />
		</form>
	</div>
	<script type="text/javascript" src="../js/user/signUp.js"></script>
</body>
</html>