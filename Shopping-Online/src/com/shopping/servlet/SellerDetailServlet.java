package com.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.model.SellerDetail;
import com.shopping.service.SellerDetailService;

public class SellerDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SellerDetailService seller = new SellerDetailService();
		List<SellerDetail> sellerList = seller.selectSeller();
		HttpSession session = req.getSession();
		session.setAttribute("sellerDetail", sellerList);
		req.getRequestDispatcher("/WEB-INF/jsp/seller_detail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
