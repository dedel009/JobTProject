package com.jobT.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobT.web.DTO.member;
import com.jobT.web.service.jobtService;

@WebServlet("/myInfo")
public class myInfoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);	//세션 생성
		String id = (String) session.getAttribute("id");
		member member = jobtService.getInstance().getMember(id);
		req.setAttribute("member", member);
		req.getRequestDispatcher("/WEB-INF/view/myInfo.jsp").forward(req, res);
	}
}
