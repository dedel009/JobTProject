package com.jobT.web.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobT.web.DTO.member;
import com.jobT.web.service.jobtService;


@WebServlet("/user/signup")
public class signUpController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");		//한글 깨짐 방지 코드
		String name = (String) req.getAttribute("name");
		String nickname = (String) req.getAttribute("nickname");
		String message ="";
		if(name==null) {
			message = "회원가입을 진행해주세요!";
		}else {
			message = "회원가입을 마저 진행해주세요!";
		}

//		System.out.println("name: "+name);
//		System.out.println("nickname: "+nickname);
		req.setAttribute("message", message);
		req.setAttribute("name", name);
		req.setAttribute("nickname", nickname);

		req.getRequestDispatcher("/WEB-INF/view/user/signUp.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");		//한글 깨짐 방지 코드
		PrintWriter out = res.getWriter();
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String nickname = req.getParameter("nickname");
		String name = req.getParameter("name");
		String category = "J";
		if(!req.getParameter("category").equals("")&&req.getParameter("category")!=null) {
			category = req.getParameter("category");
		}
		
		member member = new member(id, password, nickname, name, category);
		int result = jobtService.getInstance().createMember(member);
		HttpSession session = req.getSession(true);	//세션 생성
		session.setAttribute("id", id);	//세션에 id 값 저장
		session.setAttribute("nickname", nickname);
//		System.out.println("result: "+result);
		out.println("<script>alert('회원가입 성공!'); location.href='/JobTProject/main';</script>");
		
	}
}
