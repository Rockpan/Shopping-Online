package com.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.service.CheckUsernameService;

/**
 * 
 * @author Rock
 *
 */
public class CheckUsernameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username.length() == 0) {
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().println("<font color='red'>username can't empty</font>");
			return ;
		}
		CheckUsernameService s = new CheckUsernameService();
		int isChecked = s.checkExist(username);

		if (isChecked == -1) {
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().println("<font color='red'>username is wrong</font>");
		}
		


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);

	}
}
