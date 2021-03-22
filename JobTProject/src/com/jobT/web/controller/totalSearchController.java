package com.jobT.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobT.web.DTO.board;
import com.jobT.web.service.jobtService;

@WebServlet("/totalSearch")
public class totalSearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int page = 1;
		String query = req.getParameter("query");
		String page_ = req.getParameter("p");
		
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		List<board> searchBoard = jobtService.getInstance().getTotalSearch(page ,query);
		int count = jobtService.getInstance().getTotalSearchCount(query);
		
		req.setAttribute("count", count);
		req.setAttribute("list", searchBoard);
		req.getRequestDispatcher("/WEB-INF/view/totalSearch.jsp").forward(req, res);
	}

}
