package com.jobT.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobT.web.DTO.board;

@WebServlet("/totalSearch")
public class totalSearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String title = "";
		
		if(!title.equals("")&&title!=null) {
			title = req.getParameter("query");
		}
		List<board> searchBoard = null;
		
		
		
		req.getRequestDispatcher("/WEB-INF/view/totalSearch.jsp").forward(req, res);
	}

}
