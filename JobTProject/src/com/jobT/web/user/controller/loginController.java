package com.jobT.web.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobT.web.service.jobtService;

@WebServlet("/user/login")
public class loginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);	//세션 생성
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		String id = (String)session.getAttribute("id");
		
//		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
		
		
		System.out.println("id: "+id);
		if(id != null) {
			out.println("<script>alert('이미 로그인 되어있습니다!'); location.href='/JobTProject/main';</script>");
		}else {
			String clientId = "nU208SYz8EsU3vM29AmV";// 애플리케이션 클라이언트 아이디값";
			String redirectURI = URLEncoder.encode("http://localhost:8080/JobTProject/callback", "UTF-8"); 
		   // ex)) "http://localhost:8080/JobTProject/callback" 
			
			SecureRandom random = new SecureRandom();
			String state = new BigInteger(130, random).toString();
			String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
			apiURL += "&client_id=" + clientId;                    
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&state=" + state;          //자신의 클라이언트 아이디랑 콜백주소 State를 합쳐서 api 주소 만들고
			session.setAttribute("state", state); 
			req.setAttribute("apiURL", apiURL);   //api 주소 jsp로 보내기
			req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, res);
		}	
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String id = req.getParameter("id");
		String pass = req.getParameter("password");

		jobtService js = jobtService.getInstance();
		int result = js.login(id,pass);
		String nickname = js.getNickname(id);
//		System.out.println("login 값: "+result);
//		System.out.println("nickname 값: "+nickname);
		
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		if(result==1) {		//로그인 성공
			HttpSession session = req.getSession(true);	//세션 생성
			session.setAttribute("id", id);	//세션에 id 값 저장
			session.setAttribute("nickname", nickname);
			out.println("<script>alert('로그인 성공!'); location.href='/JobTProject/main';</script>");
		}else if(result ==0) {
			out.println("<script>alert('비밀번호가 맞지 않습니다!'); history.back();</script>");
		}else if(result == -1) {
			out.println("<script>alert('입력하신 아이디가 없습니다!'); history.back();</script>");
		}else {
			out.println("<script>alert('db 오류!'); history.back();</script>");
		}
	}
}
