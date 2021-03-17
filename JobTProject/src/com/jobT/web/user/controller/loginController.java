package com.jobT.web.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
//		System.out.println("id: "+id);
		if(id != null) {
			out.println("<script>alert('이미 로그인 되어있습니다!'); location.href='/JobTProject/board';</script>");
		}else {
			req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, res);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html; charset=UTF-8");		//한글 깨짐 방지 코드
		
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
			out.println("<script>alert('로그인 성공!'); location.href='/JobTProject/board';</script>");
		}else if(result ==0) {
			out.println("<script>alert('비밀번호가 맞지 않습니다!'); history.back();</script>");
		}else if(result == -1) {
			out.println("<script>alert('입력하신 아이디가 없습니다!'); history.back();</script>");
		}else {
			out.println("<script>alert('db 오류!'); history.back();</script>");
		}
	}
}
