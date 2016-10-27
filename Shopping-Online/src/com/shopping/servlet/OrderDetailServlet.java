package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.model.OrderDetail;
import com.shopping.service.OrderDetailService;
import com.shopping.util.Tools;

import net.sf.json.JSONArray;

/**
 * 
 * @author Rock
 *
 */
public class OrderDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String state = req.getParameter("state");
		OrderDetailService order = new OrderDetailService();
		List<OrderDetail> orderList = order.seletOrder(state);
		JSONArray array = Tools.OrdertoJsonArray(orderList);
		if (array != null) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(array.toString());
			out.flush();
			out.close();
		} else {
			System.out.println("array is null");
			response.setCharacterEncoding("utf-8");
			response.getWriter().println(orderList.toString());
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
