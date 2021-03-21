package com.jobT.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobT.web.DTO.notice;
import com.jobT.web.service.jobtService;

@WebServlet("/notice")
public class noticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int page = 1;
		int count = 0;
		String page_ = req.getParameter("p");
		
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		List<notice> list = jobtService.getInstance().getNoticeList(page);
		count = jobtService.getInstance().getNoticeCount();
		
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/view/notice.jsp").forward(req, res);
	}
}
