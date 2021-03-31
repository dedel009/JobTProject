package com.jobT.web.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobT.web.service.jobtService;

@WebServlet("/user/nicknameCheck")
public class nicknameCheckController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드

		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String passcheck = req.getParameter("passwordcheck");
		String name = req.getParameter("name");
		String nickname = req.getParameter("nickname");
		
		int result_nickCheck =  jobtService.getInstance().nicknameCheck(nickname);
		
		req.setAttribute("name", name);
		req.setAttribute("nickname", nickname);
		req.setAttribute("nickCheck", result_nickCheck);
		req.setAttribute("id", id);
		req.setAttribute("password", password);
		req.setAttribute("passwordcheck", passcheck);
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/view/user/signUp.jsp");
		rd.forward(req, res);
	}
}
