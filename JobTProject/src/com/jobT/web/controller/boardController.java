package com.jobT.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobT.web.DTO.board;
import com.jobT.web.service.jobtService;

@WebServlet("/board")
public class boardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드
		int count = 0;
		List<board> list = null;
		int page = 1;
		
		String page_ = req.getParameter("p");
		String field = req.getParameter("field");
		String query = req.getParameter("query");
		
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		if (query != null && !query.equals("")) { //검색값이 있고 페이지 클릭했을 때
			 list = jobtService.getInstance().getSearchList(page, field, query);
			 count = jobtService.getInstance().getSearchCount(page, field, query);			
		}else { //검색값 공백 페이지 클릭
			if (field != null && !field.equals("")) {
				 list = jobtService.getInstance().getSearchList(page, field, query);
				 count = jobtService.getInstance().getSearchCount(page, field, query);
			}else {
				list = jobtService.getInstance().getList(page);
				count = jobtService.getInstance().getCount();
			}
		}
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/view/board.jsp").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드

		String page_ = req.getParameter("p");
		String field = req.getParameter("field");
		String query = req.getParameter("query");
		int page = Integer.parseInt(page_);

		List<board> list = jobtService.getInstance().getSearchList(page, field, query);
		int count = jobtService.getInstance().getSearchCount(page, field, query);
		req.setAttribute("count", count);
		req.setAttribute("field", field);
		req.setAttribute("query", query);
		req.setAttribute("list", list);
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/view/board.jsp");
		rd.forward(req, res);
	}
}
