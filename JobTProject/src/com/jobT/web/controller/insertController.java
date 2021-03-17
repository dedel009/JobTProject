package com.jobT.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobT.web.service.jobtService;

@WebServlet("/insert")
public class insertController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/insert.jsp").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드
		HttpSession session = req.getSession(true); // 세션 생성
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String nickname = (String) session.getAttribute("nickname");
		jobtService js = jobtService.getInstance();
		int result = js.insertList(title, content, nickname);
		if (result == 1) {
			out.println("<script>alert('글쓰기 성공!'); location.href='board';</script>");
		} else {
			out.println("<script>alert('글쓰기 실패!'); history.back();</script>");
		}

	}
}
