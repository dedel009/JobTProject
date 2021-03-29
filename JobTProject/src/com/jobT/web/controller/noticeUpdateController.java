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
import com.jobT.web.DTO.notice;
import com.jobT.web.service.jobtService;

@WebServlet("/noticeUpdate")
public class noticeUpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드
		HttpSession session = req.getSession(true); // 세션 생성
		String place = req.getParameter("place");

		String num = (String) session.getAttribute("num");

		notice notice = jobtService.getInstance().getNoticeDetail(num);

		req.setAttribute("place", place);
		req.setAttribute("notice", notice);
		req.getRequestDispatcher("/WEB-INF/view/noticeUpdate.jsp").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드
		HttpSession session = req.getSession(true); // 세션 생성
		PrintWriter out = res.getWriter();

		String cmd = req.getParameter("cmd");
		String num = (String) session.getAttribute("num");
		String place = req.getParameter("place");

		if (cmd != null && !cmd.equals("")) {
			switch (cmd) {
			case "수정":
				out.println("<script>location.href='noticeUpdate?place="+place+"';</script>");
				break;
			case "삭제":
				int result = jobtService.getInstance().detailNoticeDelete(num);
				if (result == 1) {
					if(place.equals("board")&&place!=null) {
						out.println("<script>alert('삭제성공!'); location.href='board';</script>");
					}else if(place.equals("notice")&&place!=null) {
						out.println("<script>alert('삭제성공!'); location.href='notice';</script>");
					}
				} else {
					out.println("<script>alert('삭제실패!'); history.back();</script>");
				}
				break;
			}
		} else { 
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			jobtService js = jobtService.getInstance();
			int result = js.detailNoticeUpdate(title, content, num);
			if (result == 1) {
				if(place.equals("board")&&place!=null) {
					out.println("<script>alert('수정성공!'); location.href='board';</script>");
				}else if(place.equals("notice")&&place!=null) {
					out.println("<script>alert('수정성공!'); location.href='notice';</script>");
				}
			} else {
				out.println("<script>alert('수정실패!'); history.back();</script>");
			}
		}

	}
}
