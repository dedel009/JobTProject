<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

<style>
    .wrap {
        width: 1200px;
        margin: 0 auto;
    }

    div {
        text-align: center;
    }
    input{
    	width:30%;
    }
    .div{
    	margin-bottom: 10px;
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
        <div>
            <form action="login" method="post">
                <div class="div">
                    <input type="text" name="id" placeholder="아이디" required />
                </div>
                <div class="div">
                    <input type="text" name="password" placeholder="비밀번호" required />
                </div>
                <div class="div">
                    <input type="submit" value="로그인" /> 
                </div>
                <a href="signup" style="text-decoration: none; color: green;">회원가입</a>
            </form>
            <div style="width:250px; margin: 0 auto;">
            <a href="${n_apiURL}"><img src="/JobTProject/img/Green.PNG" style="width:250px;margin:20px 0 10px 0;"></a>
            <a id="custom-login-btn" href="${k_apiURL}">
				<img src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg" width="250px;" />
			</a>
			</div>
        </div>
    </div>
 
</body>
</html>