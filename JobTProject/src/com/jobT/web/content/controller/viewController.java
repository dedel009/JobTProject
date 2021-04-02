package com.jobT.web.content.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobT.web.DTO.commentDTO;
import com.jobT.web.DTO.imgBoard;
import com.jobT.web.service.imgContentDAO;

@WebServlet("/view")
public class viewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
	
		imgBoard ib = imgContentDAO.getInstance().getImgDetail(id);
		req.setAttribute("listdetail", ib);
		
//		String comment = req.getParameter("comment");
		
		int count = imgContentDAO.getInstance().getCommentCount(id);
		req.setAttribute("count", count);
		float avg_result = imgContentDAO.getInstance().getAvgScore(id);
		req.setAttribute("avg", avg_result);
		if(count != 0) {
			List<commentDTO> cd = imgContentDAO.getInstance().getCommentList(id);
			req.setAttribute("cd", cd);
		}

		req.getRequestDispatcher("/WEB-INF/view/view.jsp").forward(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8"); // 한글 깨짐 방지 코드
		HttpSession session = req.getSession(true);	//세션 생성
		String userID = (String) session.getAttribute("id");
		String comment = req.getParameter("comment");
		String score_ = req.getParameter("score");
		int score = Integer.parseInt(score_);
		String id = req.getParameter("id");

		commentDTO cd = new commentDTO(id, comment, score, userID);
//			System.out.println("comment: "+comment);
//			System.out.println("score: "+score);
//			System.out.println("id: "+id);
		
		int result = imgContentDAO.getInstance().insertComment(cd);

		if(result == 1) {
			System.out.println("입력성공");
		}else {
			System.out.println("입력실패");
		}
		
		res.sendRedirect("view?id="+id);


		}
}
