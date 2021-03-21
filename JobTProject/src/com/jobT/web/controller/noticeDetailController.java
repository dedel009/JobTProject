package com.jobT.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobT.web.DTO.board;
import com.jobT.web.DTO.notice;
import com.jobT.web.service.jobtService;

@WebServlet("/noticeDetail")
public class noticeDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true); // 세션 생성
		res.setContentType("text/html; charset=UTF-8");
		
		String num = req.getParameter("num");
		session.setAttribute("num", num);
		
		notice nt = jobtService.getInstance().getNoticeDetail(num);
		
		req.setAttribute("nt", nt);
		req.getRequestDispatcher("/WEB-INF/view/noticeDetail.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


	}
}
