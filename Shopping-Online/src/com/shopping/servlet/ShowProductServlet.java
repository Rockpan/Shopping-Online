/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.servlet;

import com.shopping.model.Product;
import com.shopping.service.ShowProductService;
import com.shopping.util.Tools;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;

/**
 *
 * @author Rock
 */
public class ShowProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		// System.out.println("ShowProductServlet.."+category);
		
		ShowProductService show = new ShowProductService();
		List<Product> product = show.selectProdut(category);
		
		JSONArray array = Tools.ProducttoJsonArray(product);
		// System.out.println("start json");
		if (array != null) {
			System.out.println(array.toString());
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(array.toString());
			out.flush();
			out.close();

		} else {
			System.out.println("array is null");
			response.setCharacterEncoding("utf-8");
			response.getWriter().println(product.toString());
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
