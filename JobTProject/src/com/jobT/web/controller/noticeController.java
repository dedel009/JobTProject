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

import com.jobT.web.DTO.board;
import com.jobT.web.DTO.notice;
import com.jobT.web.service.jobtService;

@WebServlet("/notice")
public class noticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드
		int count = 0;
		List<notice> list = null;
		int page = 1;
		String page_ = req.getParameter("p");
		String field = req.getParameter("field");
		String query = req.getParameter("query");
		
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		if (query != null && !query.equals("")) { //검색값이 있고 페이지 클릭했을 때
			 list = jobtService.getInstance().getNoticeList(page, field, query);
			 count = jobtService.getInstance().getNoticeCount(field, query);			
		}else { //검색값 공백 페이지 클릭
			if (field != null && !field.equals("")) {
				 list = jobtService.getInstance().getNoticeList(page, field, query);
				 count = jobtService.getInstance().getNoticeCount(field, query);		
			}else {
				 list = jobtService.getInstance().getNoticeList(page, "title", "");
				 count = jobtService.getInstance().getNoticeCount("title", "");
			}
		}
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/view/notice.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드
		String tag = "notice";
		String page_ = req.getParameter("p");
		String field = req.getParameter("field");
		String query = req.getParameter("query");
		int page = Integer.parseInt(page_);

		List<notice> list = jobtService.getInstance().getNoticeList(page, field, query);
		int count = jobtService.getInstance().getNoticeCount(field, query);	
	
		req.setAttribute("count", count);
		req.setAttribute("field", field);
		req.setAttribute("query", query);
		req.setAttribute("list", list);
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/view/notice.jsp");
		rd.forward(req, res);
	}
}
