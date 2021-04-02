package com.jobT.web.content.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobT.web.DTO.imgBoard;
import com.jobT.web.service.imgContentDAO;

@WebServlet("/imageBoard")
public class imageBoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List <imgBoard> imgList = imgContentDAO.getInstance().getImgList();

		req.setAttribute("imgList", imgList);
		req.getRequestDispatcher("/WEB-INF/view/imageBoard.jsp").forward(req, res);
	}
}
