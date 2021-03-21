package com.jobT.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobT.web.DTO.board;
import com.jobT.web.service.jobtService;

@WebServlet("/detail")
public class detailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true); // 세션 생성
		res.setContentType("text/html; charset=UTF-8");
		
		String num = req.getParameter("num");
		session.setAttribute("num", num);
		
		board board = jobtService.getInstance().getDetail(num);
		
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(true); // 세션 생성

		String cmd = req.getParameter("cmd");
		String num = (String)session.getAttribute("num");
		switch(cmd) {
		case "수정":
			out.println("<script>location.href='update';</script>");
			break;
		case "삭제":
			int result = jobtService.getInstance().detailDelete(num);
			if(result==1) {
				out.println("<script>alert('삭제성공!'); location.href='board';</script>");
			}else {
				out.println("<script>alert('삭제실패!'); history.back();</script>");		
			}
			break;
		}
	}
}
