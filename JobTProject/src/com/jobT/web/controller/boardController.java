package com.jobT.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobT.web.DTO.board;
import com.jobT.web.service.jobtService;

@WebServlet("/board")
public class boardController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<board> list = jobtService.getInstance().getList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/view/board.jsp").forward(req, res);
	}
	
}
