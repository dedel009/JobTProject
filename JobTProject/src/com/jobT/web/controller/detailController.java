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
		HttpSession session = req.getSession(true); // μΈμ μμ±
		res.setContentType("text/html; charset=UTF-8");
		
		String num = req.getParameter("num");
		session.setAttribute("num", num);
		
		board board = jobtService.getInstance().getDetail(num);
		
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(req, res);
	}

}
